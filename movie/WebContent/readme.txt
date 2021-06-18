MVC 모델 2 기반 게시판

1. 데이터 베이스 구축(=> 테이블 생성, 시퀀스 생성)															=> 완
2. 샘플 데이터 삽입, 확인(COMMIT)																		=> 완

3. DBCP 세팅																							=> 완
4. 각종 라이브러리 복사																					=> 완

5. VO 객체 제작																						=> 완
6. DB 객체 제작(DB 연결과 해제)																			=> 완
7. DAO 객체 제작																						=> 
	- 싱글턴 패턴																						=> 완
	- 각 쿼리를 호출할 메서드
		- 모든 영화 조회(SELECT)																		=> 완
		- 영화 등록(INSERT)																			=> 완
		- 영화 상세보기(SELECT : 글번호)																	=> 
		- 영화 수정(UPDATE)																			=> 
		- 영화 삭제(DELETE)																			=> 
		- 영화 암호 체크(SELECT)																		=> 

8. FrontEnd - CSS																					=> 

9. 요청을 처리하기 위한 컨트롤러
	- 모든 요청을 담당하기 위한 서블릿(MovieServlet.java)													=> 완
	- 각 요청과 처리를 위한 클래스를 연결해줄 클래스 (ActionFactory.java) => 									=> 미완

10. 요청 처리를 위한 클래스를 하나의 메서드로 묶어줄 인터페이스
	- Action 인터페이스 execute()							=> 											=> 완
	
11. 모든 게시물 보기 기능
	- 요청을 처리하기 위한 클래스 : MovieListAction.java	(Action 인터페이스를 구현받은 클래스)					=> 완
	- 화면을 보여주기 위한 뷰 : movieList.jsp															=> 완
	
12. 영화 등록 기능
	- 영화 등록 폼으로 연결시켜줄 클래스 : MovieWriteFormAction.java										=> 완
	- 영화 등록 폼 페이지 : Movie/movieWrite.jsp														=> 완
	- DAO 영화 등록 추가 : insertMovie																	=> 완
	- 포스터 업로드용 서블릿 추가 : InsertServlet(/IS)													=> 완
	- DB에 넣어줄 클래스 : MovieWriteAction.java 														=> 완
			
13.	영화 수정/삭제 => 글 상세보기
	- DAO 영화 상세보기(번호)																			=> 
	- movieList.jsp에 글 제목 클릭 시 상세보기 연결														=> 
	- 영화 상세보기 폼으로 연결시켜줄 클래스 : MovieViewAction.java											=> 
	- 영화 상세보기 폼 페이지 : movieView.jsp															=> 
	
14. 영화 수정 삭제 => 암호 확인
	- DAO 암호 체크 기능																				=> 
	- movieView.jsp에 암호 확인 페이지로 이동																=> 
	- 암호 확인 폼으로 이동을 위한 클래스 : movieCheckPassFormAction.java									=> 
	- 암호 확인 폼 페이지 : movieCheckPass.jsp															=> 
	
	- 암호 확인 버튼을 눌렀을 때
	- 암호 확인을 위한 클래스 : movieCheckPassAction.java												=> 
		- 암호 확인 실패 : 암호 확인 폼으로 돌아가기															=> 
		- 암호 확인 성공 : checkSuccess.jsp 페이지로 이동													=> 
						-> 영화 수정 : [수정기능]
						-> 영화 삭제 : [삭제기능]
	
15. 영화 삭제
	- DAO 게시글 삭제 쿼리 작성																			=> 
	- 영화 삭제를 위한 클래스 : MovieDeleteAction.java													=> 
	- 영화 삭제 후 이동할 페이지 => 목록보기																=> 
							 => BS?command=board_list

16. 영화 수정 기능
	- DAO 게시글 수정 쿼리 작성
	- 영화 수정 폼으로 이동하기 위한 클래스 : MoviepdateFormAction.java									=> 
	- 영화 수정 폼 페이지 : movieUpdate.jsp															=> 
	
	
	- 영화 수정을 위한 클래스 : MovieUpdateAction.java													=> 
	- 영화 수정후 이동할 페이지 = 목록보기																=> 
							 => BS?command=movie_list

---------------------------------------------------------------------------------------------------------
17. 페이징
	- DAO 게시글 10개씩 가져올 쿼리문 작성																	=> 
	- DAO 전체 게시글 수를 알아오는 쿼리문 작성																=> 
	- section번호와 pageNum번호를 읽어와서 
	  10개의 게시글과 전체 게시글갯수를 알아오는 쿼리 실행 BoardListAction.java								=> 
	- 4가지 정보를 가지고 boardList.jsp를 완성															=> 
	
----------------------------------------------------------------------------------------------------------


명량, 김한민, 최민식, 148,
01_myeongryang.jpg, 8.44

극한직업 이병헌, 류승룡, 95,
02_keukhan.jpg, 8.5

신과 함께 죄와벌, 김용화, 하정우, 400, 03_sin.jpg, 7.83
국제시장, 윤제균, 황정민, 180,
04_kookje.jpg, 9.02

어벤저스 엔드게임, 앤서니 루소, 로다주, 4165,
05_avengers.jpg, 9.38

겨울왕국2, 크리스 벅, 최민식, 1700,
06_kyeoul.jpg, 8.7

베테랑, 류승완, 유아인, 90,
07_ve.jpg, 9.01

아바타, 제임스 카메론, 샘 워싱턴, 2607,
08_avartar.jpg, 9.07

도둑들, 최동훈, 김윤석, 150,
09_doduk.jpg, 7.64

7번방의 선물, 이환경, 류승룡', 55,
10_seven.jpg, 8.83

암살, 최동훈, 전지현, 225,
11_amsal.jpg, 8.98

알라딘, 가이 리치, 미나 마수드, 2074,
12_aladin.jpg, 9.38

광해:왕이 된 남자, 추창민, 이병헌, 148,
13_gwanghae.jpg, 9.25

기생충, 봉준호, 송강호, 135,
14_parasite.jpg, 8.48
