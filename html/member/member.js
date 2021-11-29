
// 회원 정보를 저장할 배열 생성
var members = [];



window.onload = function () {

    // 회원 리스트 갱신
    setMemberList();

    // regForm 캐스팅 => onsubmit 이벤트 설정
    // 데이터 캐스팅 -> 객체 -> 배열에 저장

    // 폼 태그 캐스팅
    var regForm = document.getElementById('regForm');

    // 이 변수들을 onsubmit 안에만 넣으면 핸들러 안에서만 사용 가능하다.
    // 좀 더 넓게 쓸 수 있게 밖으로 빼준다.
    var userId = document.querySelector('#userId');
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var userName = document.querySelector('#userName');

    // 이벤트 설정 (이벤트 핸들러)
    regForm.onsubmit = function () {

        // alert('onsubmit!!');
        // 데이터 받아서 개체 생성


        // 사용자 입력 값의 유효성 검사
        // 아이디 검사 : 공백, 문자열의 갯수 3~8, 서버통신(비동기통신) 아이디 중복 여부
        if (userId.value.trim().length == 0) {
            // msgid 캐스팅 => 문자열 추가
            document.querySelector('#msgId').innerHTML = '아이디는 필수항목 입니다.';
            // 포커스 이동
            // userId.focus();
            // 문제가 발생했기 때문에 객체 생성을 하면 안된다.
            return false;

        } else if (!(userId.value.trim().length > 2 && userId.value.trim().length < 9)) {
            document.querySelector('#msgId').innerHTML = '아이디는 3~8자리까지 가능';
            return false;
        }


        // 비밀번호 검사 : 공백, 4~10자
        if (pw.value.trim().length == 0) {
            document.querySelector('#msgPw').innerHTML = '비밀번호는 필수항목 입니다.';
            return false;
        } else if (!(pw.value.trim().length > 4 && pw.value.trim().length < 10)) {
            document.querySelector('#msgPw').innerHTML = '비밀번호는 4~ 10자리까지 가능';
            return false;
        }

        // 비밀번호 확인 : 공백, 비밀번호와 일치 여부
        if (repw.value != pw.value) {
            document.querySelector('#msgRePw').innerHTML = '비밀번호와 일치하지 않습니다.';
            return false;
        } else if (repw.value.trim().length == 0) {
            document.querySelector('#msgRePw').innerHTML = '비밀번호 확인은 필수입니다.';
            return false;
        }

        // 이름 검사 : 공백, 2자 이상
        if (userName.value.trim().length == 0) {
            document.querySelector('msgName').innerHTML = '이름 입력은 필수입니다.';
            return false;
        } else if (userName.value.trim().length < 2) {
            document.querySelector('#msgName').innerHTML = '이름은 2자리 이상';
        }



        // 객체 생성
        var member = new Member(userId.value, pw.value, userName.value);  // 생성자 함수
        console.log('member', member);

        // 객체를 배열에 저장
        members.push(member);
        console.log('memers', members);

        // form 초기화
        // this : 이벤트가 발생한 객체를 가리킨다. -> regForm
        this.reset();

        // 입력 후 회원 리스트 갱신
        setMemberList();

        return false;
    }

    // 입력 폼에 focus가 들어가면 아래쪽 경고 메세지가 삭제되도록
    userId.addEventListener('focus', function () {
        document.querySelector('#msgId').innerHTML = '';
    });

    pw.addEventListener('focus', function () {
        document.querySelector('#msgPw').innerHTML = '';
    });

    repw.addEventListener('focus', function () {
        document.querySelector('#msgRePw').innerHTML = '';
    });

    userName.addEventListener('focus', function () {
        document.querySelector('#msgName').innerHTML = '';
    });

    // 이벤트 설정 : 입력, 수정, 삭제



}

// 기능 함수들은 전역 형태로 정의

// 데이터 저장하는 객체 생성 -> 생성자 함수
function Member(userId, pw, userName) {
    this.userId = userId;
    this.pw = pw;
    this.userName = userName;
}

// JSON -> JS Object {}

// 회원 리스트 출력을 위한 기능
function setMemberList() {

    // 화면을 갱신하는 HTML 생성
    var list = '';
    list += '<tr>';
    list += ' <th> 순번(index) </th>'
    list += ' <th> 아이디 </th> '
    list += ' <th> 비밀번호 </th>'
    list += ' <th> 이름 </th>'
    list += ' <th> 관리 </th>'
    list += '</tr>'

    if (members.length == 0) {
        list += '<tr> <td colspan="5"> 회원의 정보가 존재하지 않습니다. </td></tr>'
    } else {
        for (let i = 0; i < members.length; i++) {
            list += '<tr>';
            list += '  <td> ' + i + ' </td>'
            list += '  <td> ' + members[i].userId + ' </td>'
            list += '  <td> ' + members[i].pw + ' </td>'
            list += '  <td> ' + members[i].userName + ' </td>'
            list += '  <td>  <a href="#"> 수정 </a> | <a href="#"> 삭제 </a>  </td>'
            list += '</tr>';
        }
    }

    // tbody 캐스팅
    document.querySelector('#memberList>table>tbody').innerHTML = list;
}

