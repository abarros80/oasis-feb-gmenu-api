package oasis.feb.gestaomenu.controller;

import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import oasis.feb.gestaomenu.bean.FileInfo;
import oasis.feb.gestaomenu.bean.ResponseFileInfo;
import oasis.feb.gestaomenu.bean.ResponseMessage;
import oasis.feb.gestaomenu.service.FilesStorageService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class FilesController {
	
	
	//Logg
	private static final Logger logger = LoggerFactory.getLogger(FilesController.class);
	
	//Serviço
	  @Autowired
	  FilesStorageService storageService;
	  
	  

	  // ======================UPLOAD=============================================================================
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseFileInfo> uploadFile(@RequestParam("file") MultipartFile file) {
	    try {
	    	//Nome do ficheiro
	    	String fileName = storageService.save(file);
	    	
	    	//URI para chamada do ficheiro
	    	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/files/")
	                .path(fileName)
	                .toUriString();

	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseFileInfo(fileName, fileDownloadUri,
	              file.getContentType(), file.getSize(), true));
	      
	    } catch (Exception e) {	    	
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseFileInfo(false));	      
	    }
	  }
	  
	    @PostMapping("/uploadFiles")
	    public ResponseEntity<List < ResponseFileInfo >> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	        return ResponseEntity.status(HttpStatus.OK).body(
		        	Arrays.asList(files)
		            .stream()
		            .map(file -> uploadFileAux(file))
		            .collect(Collectors.toList())
	            );
	    }
	    
	    
	    public ResponseFileInfo uploadFileAux(MultipartFile file) {
	    	
		    try {
		    	String fileName = storageService.save(file);
		    	
		    	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/files/")
		                .path(fileName)
		                .toUriString();
		
		      return new ResponseFileInfo(fileName, fileDownloadUri,
		              file.getContentType(), file.getSize(), true);
		      
		    } catch (Exception e) {
		    	
		      return new ResponseFileInfo(false);
		      
		    }
	        
	    }
	  
	  
	  
	 
	  
	  
	
	  // ======================DOWNLOAD=============================================================================
	  @GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
	
	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());
	
	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }
	
	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename, HttpServletRequest request) {
	    Resource resource = storageService.load(filename);
	    //return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	    
	    // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
            .body(resource);
	  }

}
