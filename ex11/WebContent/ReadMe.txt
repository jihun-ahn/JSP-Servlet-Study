MVC 모델 2 기반 게시판

1. 데이터 베이스 구축(=> 테이블 생성, 시퀀스 생성)				=> 완
2. 샘플 데이터 삽입, 확인(COMMIT)							=> 완

3. DBCP 세팅												=> 완
4. 각종 라이브러리 복사										=> 완

5. VO 객체 제작											=> 완
6. DBManager 객체 제작(DB 연결과 해제)						=> 완
7. DAO 객체 제작											=> 
	- 싱글턴 패턴											=> 완
	- 각 쿼리를 호출할 메서드
		- 모든 게시물 조회(SELECT)							=> 완
		- 게시물 등록(INSERT)								=> 완
		- 게시물 조회시 카운트 증가(UPDATE)					=> 완
		- 게시글 상세보기(SELECT : 글번호)					=> 완
		- 게시글 수정(UPDATE)								=> 
		- 게시글 삭제(DELETE)								=> 
		- 게시글 암호 체크(SELECT)							=> 완

8. FrontEnd - CSS										=> 완

9. 요청을 처리하기 위한 컨트롤러
	- 모든 요청을 담당하기 위한 서블릿(BoardServlet.java)		=> 완
	- 각 요청과 처리를 위한 클래스를 연결해줄 클래스 (ActionFactory.java) => 미완

10. 요청 처리를 위한 클래스를 하나의 메서드로 묶어줄 인터페이스
	- Action 인터페이스 execute()							=> 완
	
11. 모든 게시물 보기 기능
	- 요청을 처리하기 위한 클래스 : BoardListAction.java	(Action 인터페이스를 구현받은 클래스)					=> 완
	- 화면을 보여주기 위한 뷰 : borarList.jsp															=> 미완
	
12. 글 등록 기능
	- 게시물 등록 폼으로 연결시켜줄 클래스 : BoardWriteFormAction.java	=> 연결 완료
	- 게시물 등록 폼 페이지 : board/boardWrite.jsp														=> 완
	- DAO 게시물 등록 추가																				=> 완
	- DB에 넣어줄 클래스 : BoardWriteAction.jav	 =>연결완료												=> 완
			
13.	글 수정/삭제 => 글 상세보기
	- DAO 게시물 상세보기(번호) + 조회수 증가																=> 완
	- boardList.jsp에 글 제목 클릭 시 상세보기 연결														=> 완
	- 게시물 상세보기 폼으로 연결시켜줄 클래스 : BoardViewAction.java										=> 완
	- 게시물 상세보기 폼 페이지 : boardView.jsp															=> 미완
	
14. 글 수정 삭제 => 암호 확인
	- DAO 암호 체크 기능																				=> 완
	- boardView.jsp에 암호 확인 페이지로 이동																=> 완
	- 암호 확인 폼으로 이동을 위한 클래스 : BoardCheckPassFormAction.java									=> 완
	- 암호 확인 폼 페이지 : boardCheckPass.jsp															=> 완
	
	- 암호 확인 버튼을 눌렀을 때
	- 암호 확인을 위한 클래스 : BoardCheckPassAction.java												=> 완
		- 암호 확인 실패 : 암호 확인 폼으로 돌아가기															=> 완
		- 암호 확인 성공 : checkSuccess.jsp 페이지로 이동													=> 완
						-> 글 수정 : [수정기능]
						-> 글 삭제 : [삭제기능]
	
15. 글 삭제
	- DAO 게시글 삭제 쿼리 작성																			=> 완
	- 게시글 삭제를 위한 클래스 : BoardDeleteAction.java													=> 완
	- 게시글 삭제 후 이동할 페이지 => 목록보기																=> 완
							 => BS?command=board_list

16. 글 수정 기능
	- DAO 게시글 수정 쿼리 작성
	- 게시글 수정 폼으로 이동하기 위한 클래스 : BoardUpdateFormAction.java									=> 완
	- 게시글 수정 폼 페이지 : boardUpdate.jsp															=> 완
	
	
	- 게시글 수정을 위한 클래스 : BoardUpdateAction.java													=> 완
	- 게시글 수정후 이동할 페이지 = 목록보기																=> 완
							 => BS?command=board_list


17. 페이징
	- DAO 게시글 10개씩 가져올 쿼리문 작성																	=> 완
	- DAO 전체 게시글 수를 알아오는 쿼리문 작성																=> 완
	- section번호와 pageNum번호를 읽어와서 
	  10개의 게시글과 전체 게시글갯수를 알아오는 쿼리 실행 BoardListAction.java								=> 완
	- 4가지 정보를 가지고 boardList.jsp를 완성															=> 