var app = (()=>{
    let init = () => { //맨처음에 보여줄 화면
        login_form(); //login_form은 private 메소드가 되었다.
 
    };
    let login_form = () => {
        let wrapper = document.querySelector('#wrapper'); //document = html 전체 하나. wrapper는 DOM객체(id나 class있는 것).
        wrapper.innerHTML = '<form action="/action_page.php">'
            + '  First name:<br>'
            + '  <input type="text" id= "customerId" name="customerId">'
            + '  <br>'
            + '  Last name:<br>'
            + '  <input type="text" id="password" name="password">'
            + '  <br><br>'
            + '  <input type="submit" id="btn_login" value="Login">'
            + '  <input type="button" id=btn_join value="Join">'
            + '  <input type="button" id=result_btn value="result">'
            + '</form> ';
        
        let result_btn = document.querySelector('#result_btn');
        result_btn.addEventListener('click', () => {
            result();
        })

        let btn_join = document.querySelector('#btn_join');
        btn_join.addEventListener('click', () => {
            join_form();
        });

        let login_btn = document.querySelector('#btn_login');
        login_btn.addEventListener('click',(e)=> {
            e.preventDefault();
            alert('로그인 버튼 클릭');
            id = document.getElementById('customerId').value;
            pass = document.getElementById('password').value;

            // count();
        
            let xhr = new XMLHttpRequest(),
                method='GET',
                url = 'login/' + id + '/' + pass;
                //다 담아줌. 끝에 true는 값을 빨리 보내주는 것?
                xhr.open(method, url, true);
                xhr.onreadystatechange=()=>{
                    // 밑에 상황일때만 보낼수잇음.
                    if(xhr.readyState === 4 && xhr.status === 200) {
                        let d =  xhr.responseText;
                        if(d==='SUCCESS'){
                            alert('hd');
                            wrapper.innerHTML = '<h1>마이페이지</h1>';
                        }else {
                            // login_form();     
                            wrapper.innerHTML = '<h1>로그인실패함</h1>';                       
                        }
             
                    }
                };
                xhr.send();
        });   
    }
 //열고 상태변화하고 보냄 
    let count =()=>{
        let xhr = new XMLHttpRequest();
        method = 'GET';
        url= 'count';
        xhr.open(method, url, true);
        xhr.onreadystatechange=()=>{    //데이터 상태를 말함. statechange 데이터 상태가 바뀜.
            if(xhr.readyState===4 && xhr.status === 200) {
                alert('총 고객 수 성공');
                let wrapper = document.querySelector('#wrapper'); 
                wrapper.innerHTML ='총 고객수 : <h1>' + xhr.responseText + '</h1>'
            }
        }
        xhr.send();
    }

    let result =()=> {
        let xhr = new XMLHttpRequest();
        method = 'GET';
        url= 'login';
        xhr.open(method, url, true);
        xhr.onreadystatechange=()=>{    //데이터 상태를 말함. statechange 데이터 상태가 바뀜.
            if(xhr.readyState===4 && xhr.status === 200) {
                alert('result성공');
                let wrapper = document.querySelector('#wrapper'); 
                wrapper.innerHTML ='성공여부: <h1>' + xhr.responseText + '</h1>'
            }
        }
        xhr.send();
    }

        let join_form = () => {
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML =
             '<form action="/action_page.php">'
             + '  id:<br>'
             + '  <input type="text" name="id" value="id">'
             + '  <br>'
             + '  pw:<br>'
             + '  <input type="text" name="pw" value="pw">'
             + '  <br>'
             + '  name:<br>'
             + '  <input type="text" name="c_name" value="name">'
             + '  <br>'
             + '  birth:<br>'
             + '  <input type="text" name="birth" value="birth">'
             + '  <br>'
             + '  phone:<br>'
             + '  <input type="text" name="phone" value="phone">'
             + '  <br><br>'
             + '  <input type="submit" id="btn_confirm" value="확인">'
            //  + '  <input type="reset" id="btn_cancel" value="취소">'
             +'</form> '
 
 
        let btn_confirm = document.querySelector('#btn_confirm');
        btn_confirm.addEventListener('click', () => {
            login_form();
        });

        
    }

    return {
        aa: init  //init은 public 메소드가 되었다
    };
 })(); //();  끝에 이부분이 '즉시 실행해라' 라는 것