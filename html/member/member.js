
// 회원 정보를 저장할 배열 생성
var members = [];



window.onload = function () {
    // regForm 캐스팅 => onsubmit 이벤트 설정
    // 데이터 캐스팅 -> 객체 -> 배열에 저장

    // 폼 태그 캐스팅
    var regForm = document.getElementById('regForm');
    // 이벤트 설정 (이벤트 핸들러)
    regForm.onsubmit = function () {

        // alert('onsubmit!!');
        // 데이터 받아서 개체 생성
        var userId = document.querySelector('#userId');
        var pw = document.querySelector('#pw');
        var repw = document.querySelector('#repw');
        var userName = document.querySelector('#userName');

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
            document.querySelector('#msgId').innerHTML = '아이디는 3~8자리까지 가능합니다.';
            return false;
        }


        // 비밀번호 검사 : 공백, 4~10자
        if (pw.value.trim().length == 0) {
            document.querySelector('#msgPw').innerHTML = '비밀번호는 필수항목 입니다.';
            return false;
        } else if (!(pw.value.trim().length > 4 && pw.value.trim().length < 10)) {
            document.querySelector('#msgPw').innerHTML = '비밀번호는 4자리 ~ 10자리까지 가능합니다.';
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
            document.querySelector('#msgName').innerHTML = '이름은 2자리 이상이여야 합니다.';
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

        return false;
    }


    // 이벤트 설정 : 입력, 수정, 삭제



}

// 기능 함수들은 전역 형태로 정의

// 데이터 저장하는 객체 생성 -> 생성자 함수
function Member(userId, pw, userName) {
    this.userId = userId;
    this.pw = pw;
    this.userName = userName;
}

