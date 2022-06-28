# Git

---



### Git 초기 설정

- 최초 **한 번만** 설정
- **누가** 커밋 기록을 남겼는지 **확인**할 수 있도록 이름과 이메일 설정
- **`git config --global user.name "이름"`** 
- **`git config --global user.email "메일 주소"`**
- 확인 => **`git config --global -l`**

---

### Git 기본 명령어

1. **`git init`**
   - 현재 작업 중인 디렉토리를 Git으로 관리한다는 명령어
   - **이미 Git 저장소인 폴더 내에 또 다른 Git 저장소 생성 금지**
2. **`git status`**
   - Working Directory와 Staging Area에 있는 파일의 현재 상태를 알려주는 명령어
   - **작업을 시행하기 전에 수시로 status를 확인**
3. **`git add`**
   - Working Directory에 있는 파일을 Staging Area로 올리는 명령어
   - Git이 해당 파일을 **추적(관리)**할 수 있도록 만듬
   - **`git add test.txt`** => 특정 파일 
   - **`git add .`**  => 현재 디렉토리에 속한 파일/폴더 중 변경사항 있는 **전부**
4. **`git commit`**
   - Staging Area에 올라온 파일의 변경 사항을 하나의 버전(커밋)으로 저장하는 명령어
   - **`-m "메세지"`** 명령어로 커밋 메세지 입력 가능
   - **커밋 메세지**는 현재 변경 사항들을 잘 나타낼 수 있도록 **의미** 있게 작성
5. **`git log`**
   - 커밋의 내역(**ID, 작성자, 시간, 메세지 등**)을 조회할 수 있는 명령어
   - **`git log --oneline`** 한 줄로 축약해서 표시

---

# Github

---



### Github 연결

- **`git remote`**

  1. ##### 등록

     - **`git remote add <이름> <주소>`**
     - **`git remote add origin https://github.com/ks-hyunn/TIL`**

  2. ##### 조회

     - **`git remote -v`**

     - add를 이용해 추가했던 원격 저장소의 이름과 주소 출력

  3. ##### 삭제

     - **`git remote rm <이름>`**

     - 로컬과 원격 저장소의 연결을 끊는 것

---

### Github 업로드

- 파일을 업로드하는 게 아니라 **커밋을 업로드** 하는 것

  1. 로컬 저장소에서 커밋 생성

  2. **`git push`**

     - 로컬 저장소의 커밋을 원격 저장소에 업로드하는 명령어

     - **`git push <저장소 이름> <브랜치 이름>`**

     - **`-u`** 옵션을 사용하면, 두 번째 부터는 **`<저장소 이름> <브랜치 이름>`** 생략 가능

     - **`git push -u origin master`**

       



