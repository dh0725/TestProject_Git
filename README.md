# TestProject_Git
테스트프로젝트 깃

---

### A. STS19_REST

---

### B. STS19_REST에 사용된 기술
1. Spring에서는 @Controller 라는 어노테이션을 사용해서 컨트롤러를 명시해주고 View를 사용한다.
그러나 @RestController를 사용하면 뷰페이지 필요없이 return을 통해 결과를 반환해준다.

---

### C. 프로젝트 셋업에 관한 절차 
1. 로컬 저장소 준비하기
    1. STS19_REST를 import 해 온 후 프로젝트 우클릭->Team->Share Project를 통해 Local Repository를 생성한다.
    2. Git Property를 열어서 Git Staging을 보고 변경된 사항들을 확인한다.
    3. 공유가 필요없는 것들은 .gitignore라는 텍스트 파일에 추가해서 공유되지 않도록 설정한다.
    4. 변경된 사항들을 add 한 후 commit한다.
    
2. 원격 저장소 준비하기
    1. GitHub에서 새로운 repository를 생성한 후 주소를 복사한다.
    2. 이클립스로 돌아와서 Git Property에서 프로젝트안의 Remote라는 폴더에서 우클릭을 해서 Create Remote를 해준다.
        1. Remote 설정을 다 해준다.
    3. Remote 설정이 완료되면 Remote/origin에서 Push를 통해 로컬 저장소의 파일들을 원격저장소로 Push 해준다.
    4. GitHub에서 새로고침을 통해 잘 Push 되었는지 확인한다.

3. README.md
    1. GitHub에서 READEME.md를 만들어준다.
    2. 기입할 내용들을 적어준다.
    3. 아래의 Commit New File / Commit changes를 해주고
    4. 이클립스에서 프로젝트 우클릭->Pull을 통해 원격 저장소에서 로컬저장소로 Pull 해온다.
    5. 끝!
