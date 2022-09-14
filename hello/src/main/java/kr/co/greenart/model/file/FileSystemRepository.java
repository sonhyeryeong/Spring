package kr.co.greenart.model.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileSystemRepository implements FileRepository {
	private final File saveFolder = new File("d:\\temp\\");
	private Path root = Paths.get("d:\\temp\\");
	
	@Override
	public Resource getByName(String fileName) {
		try {
			return new UrlResource(new File(saveFolder.getAbsolutePath()
			               + File.separator
			               + fileName).toURI());
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getAllnames() { //파일 배열을 반환한다. 
		File[] filearr =  saveFolder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return !pathname.isDirectory();//폴더가 아닌 파일 이름만 반환한다. 
			}
		});
		List<String> list = new ArrayList<String>();
		for(File f : filearr) {
			list.add(f.getName());
		}
		return list;
		
		//람다식(자바8버젼부터 가능)
//		try {
//			Files.walk(root ,1)
//				.filter(t -> !t.equals(root))
//				.filter(x -> !Files.isDirectory(x))
//				.map(y -> y.toString())
//				.collect(Collectors.toList());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	
	@Override
	public int save(MultipartFile file) {
		File saveFolder = new File("d:\\temp\\");
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		try {
			file.transferTo(new File(saveFolder.getAbsolutePath()
		               + File.separator
		               + file.getOriginalFilename()));
			return 1;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return 0; 
		}
		
//		2.
//		Path saveFolder = Paths.get("d:\\");
//		try {
//			if(!Files.exists(saveFolder)) {
//				Files.createDirectories(saveFolder);
//			}
//			file.transferTo(saveFolder.resolve(Paths.get(file.getOriginalFilename())).normalize());
//			return 1;
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//			return 0;
//		}
		
	}
	

}
