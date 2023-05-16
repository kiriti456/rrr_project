package com.rrr.vtr;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ForMain {
	public static void main(String[] args) throws FileNotFoundException {
		
		String[] array =  {"Cast","Constituency","DataSource","Party","PollingStation","Relation","Religion","Section","SubCast","VoterDetail","VoterFamily"};


		String controllerTemplate =  
					"package com.rrr.vtr.controller;\r\n"
					+"\r\n"
					+"\r\n"
					+"import java.util.List;\r\n"
					+"\r\n"
					+"import org.slf4j.Logger;\r\n"
					+"import org.slf4j.LoggerFactory;\r\n"
					+"import org.springframework.beans.factory.annotation.Autowired;\r\n"
					+"import org.springframework.http.MediaType;\r\n"
					+"import org.springframework.http.ResponseEntity;\r\n"
					+"import org.springframework.web.bind.annotation.GetMapping;\r\n"
					+"import org.springframework.web.bind.annotation.PostMapping;\r\n"
					+"import org.springframework.web.bind.annotation.RequestBody;\r\n"
					+ "import org.springframework.web.bind.annotation.RequestMapping;\r\n"
					+ "import org.springframework.web.bind.annotation.ResponseBody;\r\n"
					+ "import org.springframework.web.bind.annotation.RestController;\r\n"
					+ "\r\n"
					+ "import com.rrr.vtr.jpa.entity.CAP_class;\r\n"
					+ "import com.rrr.vtr.service.CAP_classService;\r\n"
					+ "\r\n"
					+ "@RestController\r\n"
					+ "@RequestMapping(\"/SML_class\")\r\n"
					+ "public class CAP_classController {\r\n"
					+ "	\r\n"
					+ "	Logger logger = LoggerFactory.getLogger(getClass());\r\n"
					+ "	\r\n"
					+ "	@Autowired\r\n"
					+ "	CAP_classService SML_classService;\r\n"
					+ "	\r\n"
					+ "	@GetMapping(path=\"/get\", produces=MediaType.APPLICATION_JSON_VALUE)\r\n"
					+ "	public ResponseEntity<List<CAP_class>> getCAP_class() {\r\n"
					+ "		logger.info(\"inside get\");\r\n"
					+ "		return ResponseEntity.ok(SML_classService.findAll());\r\n"
					+ "	}\r\n"
					+ "	\r\n"
					+ "	@PostMapping(path=\"/save\", produces=MediaType.APPLICATION_JSON_VALUE)\r\n"
					+ "	public ResponseEntity<CAP_class> saveCAP_class(@RequestBody CAP_class SML_class) {\r\n"
					+ "		logger.info(\"inside save\");\r\n"
					+ "		return ResponseEntity.ok(SML_classService.save(SML_class));\r\n"
					+ "	}\r\n"
					+ "\r\n"
					+ "}";

		String serviceTemplate = "package com.rrr.vtr.service;\r\n"
					+ "\r\n"
					+ "import java.util.List;\r\n"
					+ "\r\n"
					+ "import com.rrr.vtr.jpa.entity.CAP_class;\r\n"
					+ "\r\n"
					+ "public interface SML_classService {\r\n"
					+ "\r\n"
					+ "	List<CAP_class> findAll();\r\n"
					+ "	CAP_class save(CAP_class SML_class);\r\n"
					+ "	CAP_class findById(Long id);\r\n"
					+ "	CAP_class update(CAP_class SML_class);\r\n"
					+ "}\r\n"
					+ "";

		String serviceImplTemplate = "package com.rrr.vtr.service.impl;\r\n"
					+ "\r\n"
					+ "import java.util.List;\r\n"
					+ "\r\n"
					+ "import org.springframework.beans.factory.annotation.Autowired;\r\n"
					+ "import org.springframework.stereotype.Component;\r\n"
					+ "\r\n"
					+ "import com.rrr.vtr.jpa.entity.CAP_class;\r\n"
					+ "import com.rrr.vtr.jpa.repo.CAP_classRepository;\r\n"
					+ "import com.rrr.vtr.service.CAP_classService;\r\n"
					+ "\r\n"
					+ "@Component\r\n"
					+ "public class CAP_classServiceImpl implements CAP_classService {\r\n"
					+ "	\r\n"
					+ "	@Autowired\r\n"
					+ "	CAP_classRepository SML_classRepo;"
					+ "\r\n"
					+ "}";
		
		for(String s : array) {
			PrintWriter writer = new PrintWriter(new FileOutputStream("c:/satya/tmp/"+s+"Controller.java"));
			writer.print(controllerTemplate.replaceAll("CAP_class", s).replaceAll("SML_class", new String(s.charAt(0)+"".toLowerCase()+s.substring(1,s.length()-1))));
			writer.flush();
			writer.close();
			PrintWriter writer1 = new PrintWriter(new FileOutputStream("c:/satya/tmp/"+s+"Service.java"));
			writer1.print(serviceTemplate.replaceAll("CAP_class", s).replaceAll("SML_class", new String(s.charAt(0)+"".toLowerCase()+s.substring(1,s.length()-1))));
			writer1.flush();
			writer1.close();
			PrintWriter writer2 = new PrintWriter(new FileOutputStream("c:/satya/tmp/"+s+"ServiceImpl.java"));
			writer2.print(serviceImplTemplate.replaceAll("CAP_class", s).replaceAll("SML_class", new String(s.charAt(0)+"".toLowerCase()+s.substring(1,s.length()-1))));
			writer2.flush();
			writer2.close();
		}
	}
}
