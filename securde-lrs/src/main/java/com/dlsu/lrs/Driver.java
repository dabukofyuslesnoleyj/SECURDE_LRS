package com.dlsu.lrs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException {
		generateRepos(
				"src/main/java/",
				"com.dlsu.lrs.models",
				"com.dlsu.lrs.repo");
	}
	
	public static void generateRepos(String root, String srcPkg, String destPkg) throws IOException {
		File src = new File(root + srcPkg.replace('.', '/'));
		for(File f : src.listFiles()) {
			String name = f.getName().replaceAll(".java$", "");
			String out = "";
			
			out += "package " + destPkg + ";\r\n\r\n";
			out += "import org.springframework.data.repository.CrudRepository;\r\n\r\n";
			out += "import com.dlsu.lrs.models." + name + ";\r\n\r\n";
			out += "public interface " + name + "Repository extends CrudRepository<"+ name + ", String> {\r\n}\r\n";
			
			File nf = new File(root + destPkg.replace('.', '/') + "/" + name + "Repository.java");
			FileWriter writer = new FileWriter(nf);
			writer.write(out);
			writer.close();
		}
	}
}
