# wind

## 1️⃣ 커밋 메시지 규칙

### 형식
```
Type :: Title

Body
```

### 상세 규칙
- 헤더는 type을 지정해 주고, title을 명령문으로 작성한다.
- 헤더는 너무 길지 않도록 한다.
- Body에는 해당 커밋에서 무엇을 왜 하였는지 구체적으로 서술한다.
- Footer는 선택사항.
- 원활한 소통을 위해 한글로 작성한다.

### Header Type
| type | description |
| --- | --- |
| ADD | 새로운 기능 |
| FIX | 버그 수정 |
| REFACTOR | 코드 리팩토링 |
| TEST | 테스트 코드 작성 |
| SET | 프로젝트 세팅 |
| CHORE | 자잘한 일 |
| DOCS | 문서 추가 |
| DELETE | 삭제 |

### 명령어 예시
```bash
git commit -m "ADD :: 원서 객체
- ~~ 구체적인 설명
"
```
