# JellyMolyServer
전자정부 프레임워크를 기반으로 개발중인 JellyMoly 서버입니다.

## API SPEC

- 모든 POST요청의 payload 인코딩 유형은 'x-www-form-urlencoded' 입니다.
- 요청에 성공하면 code값이 0이 반환됩니다.
- 에러가 발생한 경우 message에 에러 메시지가 표시됩니다.


### 1. 유저 조회
```
GET /JellyMolyServer/user.do?no=:no
```

#### Parameter
* no: 유저번호

#### Response
```
{
   "code":0,
   "message":"",
   "user":{
      "joinDate":2021,
      "sex":1,
      "name":"FZ",
      "likeSound":"물컹",
      "seq":1,
      "jellyFrequency":1,
      "age":3
   }
}
```

#### Error
* 800 – Not Found

### 2. 유저 생성
```
POST /JellyMolyServer/newUser.do
```

#### Parameter
* sex: 성별, 0:알수없음 1:여성 2:남성
* name: 이름
* likeSound: 선호하는 소리 (TAG)
* jellyFrequency: 주간 젤리먹는 횟수
* age: 연령대

#### Response
```
{"code":0,"message":""}
```

#### Error

### 3. 컨텐츠 목록 조회
```
GET /JellyMolyServer/contentList.do?page=:page
```

#### Response
```
{
   "code":0,
   "count":1,
   "message":"",
   "list":[
      {
         "date":0,
         "hit":0,
         "subject":"테스트",
         "price":0,
         "text":"ㅇㅇㅇ",
         "category":"젤리",
         "seq":0,
         "userSeq":1
      }
   ]
}
```

* page: 페이지 번호

#### Error
