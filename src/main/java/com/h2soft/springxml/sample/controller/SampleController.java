package com.h2soft.springxml.sample.controller;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.h2soft.springxml.sample.domain.SampleDTO;
import com.h2soft.springxml.sample.domain.SampleDTOList;
import com.h2soft.springxml.sample.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	//@Log4j 빨간불일때 pom.xml log4j의 의존성에 <scope>runtime</scope>을 제거
	
	//@RequestMapping 기본형
	@RequestMapping("")
	public void basic() {
		log.info("basic.....");
	}
	
	//@RequestMapping 속성
	@RequestMapping(value = "/basic" , method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basicGet.....");
	}
	
	//@GetMapping 속성
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basicGet2.....");
	}
	
	//@GetMapping 객체 전달 
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("ex01....."+dto);
		return "ex01";
	}
	
	//@GetMapping @RequestParam 직접 표현 방식
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name,@RequestParam("age") int age) {
		log.info("ex02.....");
		log.info("name : "+name);
		log.info("age : "+age);
		return "ex02";
	}
	
	//ArrayList 리스트 처리 http://localhost:8080/sample/ex02List?ids=aa&ids=11
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ex02List.....");
		log.info("ids : "+ids);
		return "ex02List";
	}
	
	//ArrayList 배열 처리 http://localhost:8080/sample/ex02Array?ids=aa&ids=11
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("ex02Array.....");
		log.info("ids : "+Arrays.toString(ids));
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("ex02Bean.....");
		log.info("list : "+list);
		return "ex02Bean";
	}
	
	//2022-01-01 데이타가 들어오는 경우 문제 해결 방법 
	//TodoDTO에서 특정필드에 @DateTimeFormat 선언하는 경우에는 @InitBinder 필요하지 않음
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dataformat, false));
//	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("ex03.....");
		log.info("todo : "+todo);
		return "ex03";
	}
	
	//SampleDTO 은 geter/seter javaBean 규칙이 맞기 때문 자동 화면 전달됨.
	@GetMapping("/ex04")
	public String ex03(SampleDTO dto,@ModelAttribute("page") int page) {
		log.info("ex04.....");
		log.info("page : "+dto);
		log.info("page : "+page);
		return "/sample/ex04";
	}
	
	//json 응답방식
	@GetMapping("/ex06")
	@ResponseBody
	public SampleDTO ex06() {
		log.info("ex06.....");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("ex07.....");
		String msg = "{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
	
	//파일업로드 Jsp 화면
	@GetMapping("/exUpload")
	public String exUpload() {
		log.info("exupload.....");
		return "/sample/exUpload";
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			log.info("===========================");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
		});
	}
	
}
