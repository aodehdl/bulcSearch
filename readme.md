# bulcSearch
책 검색 API 를 이용한 검색 서비스 

> * 검색, 검색 히스토리, 상세 페이지 

> * 기본포트는 8080 을 사용합니다. 

> * DB는 서버를 재시작하면 데이타가 초기화 됩니다. 

### 환경 
1. Java 8 버전을 사용
1. gradle
1. feign api 연동용
1. h2 DB용도
1. sha512.js  < 비밀번호 암호화 용도
1. jquery 1.12.4


### 설치

```
$ git clone https://github.com/aodehdl/bulcSearch.git
$ cd bulcSearch

```

### 실행(로컬)

```
$ gradle bootrun -Dfile.encoding=UTF-8
```


<p style='margin: 0px 0px 10px; color: rgb(107, 113, 122); text-transform: none; text-indent: 0px; letter-spacing: normal; font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 13px; font-style: normal; word-spacing: 0px; white-space: normal; box-sizing: border-box; orphans: 2; widows: 2; font-variant-ligatures: normal; font-variant-caps: normal; -webkit-text-stroke-width: 0px; text-decoration-style: initial; text-decoration-color: initial;'><div style="box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">1. 상반기 정리&nbsp;</span></div><p></p><p style='margin: 0px 0px 10px; color: rgb(107, 113, 122); text-transform: none; text-indent: 0px; letter-spacing: normal; font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 13px; font-style: normal; word-spacing: 0px; white-space: normal; box-sizing: border-box; orphans: 2; widows: 2; font-variant-ligatures: normal; font-variant-caps: normal; -webkit-text-stroke-width: 0px; text-decoration-style: initial; text-decoration-color: initial;'><ul style="margin-top: 0px; margin-bottom: 10px; box-sizing: border-box;"></ul><p></p><ul style='color: rgb(0, 0, 0); text-transform: none; text-indent: 0px; letter-spacing: normal; font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 14px; font-style: normal; margin-top: 0px; margin-bottom: 10px; word-spacing: 0px; white-space: normal; box-sizing: border-box; orphans: 2; widows: 2; font-variant-ligatures: normal; font-variant-caps: normal; -webkit-text-stroke-width: 0px; text-decoration-style: initial; text-decoration-color: initial;'><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; font-size: 13px; box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">카카오뱅크의 유지보수를 업무를 수행했습니다.</span></li><ul style='color: rgb(0, 0, 0); text-transform: none; text-indent: 0px; letter-spacing: normal; font-family: "Helvetica Neue", Helvetica, Arial, sans-serif; font-size: 14px; font-style: normal; margin-top: 0px; margin-bottom: 10px; word-spacing: 0px; white-space: normal; box-sizing: border-box; orphans: 2; widows: 2; font-variant-ligatures: normal; font-variant-caps: normal; -webkit-text-stroke-width: 0px; text-decoration-style: initial; text-decoration-color: initial;'><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; font-size: 13px; box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">&nbsp;</span><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">기업 뱅킹 장애 모니터링&nbsp;</span></li><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; font-size: 13px; box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">고객 센터 요청 사항 응대</span></li><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; font-size: 13px; box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">장애/ 오류 상태 발생에 대해 조치</span></li><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; font-size: 13px; box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">&nbsp;</span><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">기업 뱅킹 솔루션 관리&nbsp;</span></li><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; font-size: 13px; box-sizing: border-box;"><span style="color: rgb(0, 0, 0); font-family: 돋움,Dotum;">보안 취약점 개선&nbsp;</span></li><li style="color: rgb(107, 113, 122); font-family: 돋움,Dotum; 
