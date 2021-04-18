# JellyMolyServer
전자정부 프레임워크를 기반으로 개발중인 JellyMoly 서버입니다.

## API SPEC
모든 POST요청의 payload 인코딩 유형은 'x-www-form-urlencoded' 입니다.

### 1. 유저 조회
```
GET /JellyMolyServer/user.do?no=[유저번호]
```
* 유저번호: 유저 seq

#### Response

#### Error

### 2. 유저 생성
```
POST /JellyMolyServer/newUser.do
```

#### Parameter

#### Response

#### Error

### 3. 컨텐츠 목록 조회
```
GET /JellyMolyServer/contentList.do?page=[페이지번호]
```

#### Response

#### Error
