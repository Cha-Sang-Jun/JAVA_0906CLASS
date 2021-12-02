
// jQuery 이벤트 설정으로 대체 : 2021.12.02
// 회원 정보를 저장할 배열 생성
var members = [];

$(document).ready(function () {
    alert('onload');

    // 회원 리스트 갱신
    // 로컬스토리지에 데이터가 존재 하는지 확인 후 처리
    // getItem(key) 데이터 없으면 null 반환
    if (localStorage.getItem('members')) {
        // Not null : 저장되어 있는 JSON 문자열을 -> 자바스크립트의 배열로 변경
        members = JSON.parse(localStorage.getItem('members'));
    } else {
        // null -> 비어있는 배열을 저장
        localStorage.setItem('members', JSON.stringify(members));
    }

    console.log(members);

    setMemberList();

    // regForm 캐스팅 => onsubmit 이벤트 설정
    // 데이터 캐스팅 -> 객체 -> 배열에 저장

    // 폼 태그 캐스팅 (jQuery 객체)
    var regForm = $('#regForm');
    var userId = $('#userId');
    var pw = $('#pw');
    var repw = $('#repw');
    var userName = $('#userName');

    // 이벤트 설정 : 입력
    regForm.submit(function () {
        // 데이터 받아서 객체 생성
        // 사용자 입력 값의 유효성 검사
        // 아이디 검사 : 공백, 글자수, 서버통신(비동기통신) 아이디 중복 여부
        // value -> val() 기존에 있던 value 속성 값을 가져온다. -> 기존의 document 객체에서 jQuery 객체로변경
        if (userId.val().trim().length == 0) {
            // msgid 캐스팅 => 문자열 추가
            $('#msgId').html('아이디는 필수항목입니다.');
            return false;
        } else if (!(userId.val().trim().length > 2 && userId.val().trim().length < 9)) {
            $('#msgId').html('아이디는 3~8자리 까지 가능합니다.');
            return false;
        }

        // 비밀번호 검사 : 공백, 글자수
        if (pw.val().trim().length == 0) {
            $('#msgPw').html('비밀번호는 필수항목입니다.');
            return false;
        } else if (!(pw.val().trim().length > 3 && pw.val().trim().length < 10)) {
            $('#msgPw').html('비밀번호는 4~10자리까지 가능');
            return false;
        }

        // 비밀번호 확인 : 공백, 비밀번호와 일치 여부
        if (repw.val() != pw.val()) {
            $('#msgRePw').html('비밀번호와 일치하지 않습니다.');
            return false;
        } else if (repw.val().trim().length == 0) {
            $('#msgRePw').html('비밀번호 확인은 필수입니다.');
            return false;
        }

        // 이름 검사 : 공백, 글자수
        if (userName.val().trim().length == 0) {
            $('#msgName').html('이름 입력은 필수입니다.');
            return false;
        } else if (userName.val().trim().length < 2) {
            $('#msgName').html('이름은 2자리 이상');
            return false;
        }


        // 객체 생성
        var member = new Member(userId.val(), pw.val(), userName.val());  // 생성자 함수
        console.log('member', member);

        // 객체를 배열에 저장
        members.push(member);
        console.log('members', members);

        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        // form 초기화
        // this : 이벤트가 발생한 객체를 가리킨다. -> regForm
        this.reset();

        // 입력 후 회원 리스트 갱신
        setMemberList();

        return false;
    });


    // 입력 폼에 focus가 들어가면 아래쪽 경고 메세지가 삭제
    userId.focusin(function () {
        $('#msgId').html('');
    });

    pw.focusin(function () {
        $('#msgPw').html('');
    });

    repw.focusin(function () {
        $('#msgRePw').html('');
    });

    userName.focusin(function () {
        $('#msgName').html('');
    })

    ////////////////////////////////////////////////////////////////////////////
    // 수정 폼 이벤트 설정
    var editForm = $('#editForm')
    var index = $('#index');
    var epw = $('#epw');
    var erepw = $('#erepw');
    var ename = $('#ename');
    var resetBtn = $('#resetBtn');

    // 유효성 검사
    editForm.submit(function () {

        // index 값 존재 유무 확인
        if (index.val().trim().length == 0) {
            alert('유효한 인덱스 값이 아닙니다. \n프로그램을 다시 시작하세요.')
            return false;
        }

        // epw 공백, 문자 사이즈 확인
        if (epw.val().trim().length == 0) {
            alert("비밀번호는 필수항목입니다.")
            this.focus();  // this.focus();
            return false;
        } else if (!(epw.val().trim().length > 3 && epw.val().trim().length < 10)) {
            alert("비밀번호는 4~10자리 문자열만 가능합니다.")
            this.focus();
            return false;
        }

        // erepw 공백, epw 일치여부
        if (erepw.val().trim().length == 0) {
            alert("비밀번호 확인은 필수항목 입니다");
            this.focus();
            return false;
        } else if (!(erepw.val() == epw.val())) {
            alert("비밀번호가 일치하지 않습니다.");
            erepw[0].focus();
            return false;
        }
        // ename 공백, 문자열 사이즈 확인
        if (ename.val().trim().length == 0) {
            alert("사용자 이름은 필수항목 입니다.");
            ename[0].focus();
            return false;
        } else if (ename.val().trim().length < 2) {
            alert("이름은 최소 2자 이상이여야 합니다.");
            ename[0].focus();
            return false;
        }

        // index 위치의 배열의 요소에 현재 캐스팅한 데이터를 입력
        members[index.val()].pw = epw.val().trim();
        members[index.val()].userName = ename.val().trim();

        // 저장
        localStorage.setItem('members', JSON.stringify(members));

        // 화면 갱신
        setMemberList();

        alert('수정되었습니다.');

        // 수정 폼 영역 비 노출 처리    
        editFormClose();

        return false;
    });

    resetBtn.click(function () {
        epw.val(members[index.val()].pw);    // index를 안에서 쓸수 있는 이유는 index 캐스팅이 되어있기때문
        erepw.val(members[index.val()].pw);
        ename.val(members[index.val()].ename);
    });

});

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
        list += '<tr> <td colspan="5"> 회원의 정보가 존재하지 않습니다. </td> </tr>'

    } else {
        $.each(members, function (index, item) {
            list += '<tr>';
            list += '  <td> ' + index + ' </td>'
            list += '  <td> ' + item.userId + ' </td>'
            list += '  <td> ' + item.pw + ' </td>'
            list += '  <td> ' + item.userName + ' </td>'
            list += '  <td>  <a href="javascript:editMemberForm(' + index + ')"> 수정 </a> | <a href="javascript:deleteMember(' + index + ')"> 삭제 </a>  </td>'
            list += '</tr>';
        });
    }

    // tbody 캐스팅
    $('#memberList>table>tbody').html(list);
}

// 수정 영역을 보이도록 처리하는 함수 : 클릭한 인덱스의 데이터가 폼에 입력되어 있어야함
function editMemberForm(index) {
    // 수정 폼 영역이 노출 되어야 한다.
    $('#editFormArea').css('display', 'block');

    var member = members[index];
    $('#index').val(index);
    $('#eid').val(member.userId);
    $('#epw').val(member.pw);
    $('#erepw').val(member.pw);
    $('#ename').val(member.userName);
}


// 수정 영역을 닫는 함수
function editFormClose() {
    // document.querySelector('#editFormArea').style.display = 'none';
    $('#editFormArea').css('display', 'none');
}

// 배열의 데이터를 삭제하는 함수
function deleteMember(index) {

    // 배열의 요소를 삭제: splice(index, count)

    if (confirm('정말 삭제하시겠습니까?')) {
        members.splice(index, 1);

        // 저장 
        localStorage.setItem('members', JSON.stringify(members));

        alert('삭제되었습니다.');

        // 리스트 갱신
        setMemberList();
    }
}
