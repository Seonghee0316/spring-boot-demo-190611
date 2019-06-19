// 내 코드
var app =  {
    $wrapper :  $wrapper = document.querySelector('#wrapper'),
    init : init
};

var customer = {
    join_form : join_form,
    join : join,
    login_form : login_form,
    login : login,
    mypage : mypage,
    mypage_form : mypage_form,
    count : count ,
    update_form : update_form,
    update : update,
    remove : remove
};

var session = {
    set_value : set_value,
    get_value : get_value
};

// x라는 session만듬 토스는 지문을 사용자 폰에 저장함.
function set_value(x) {
    sessionStorage.setItem(x.name, x.value);
}

function get_value(x){
    return sessionStorage.getItem(x);
}

function init(){
    $wrapper.innerHTML = customer.login_form();
    document.getElementById('join-btn')
    .addEventListener('click',()=>{
        $wrapper.innerHTML = customer.join_form();
        document.getElementById('confirm-btn')
        .addEventListener('click', e=>{
            e.preventDefault();
            customer.join();
        });
    });

    document.getElementById('login-btn')
        .addEventListener('click', e=>{
            e.preventDefault(); //이거 쓰게 하지말고 밑에꺼 쓰라? 오리지널로 나오는 거쓰지 말고. 기본으로 걸어주기.
            alert('로그인 버튼 클릭');
            customer.login();
            
        });
}

function count(){
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'customers/count', true);
    xhr.onload=()=>{
        if(xhr.readyState===4 && xhr.status === 200){
            alert('성공');
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = '총 고객수 : <h1>'+xhr.responseText+'</h1>'
        }
    }
    xhr.send();
};

function join_form(){
    return '<form>'
    + '아이디<br>'
    +'	<input type="text" id="customerId" name="id"><br>'
    +'	비밀번호<br>'
    +'	<input type="password" id="password" name="pw"><br>'
    +'	이 름<br>'
    +'	<input type="text" id="customerName" name="name"><br>'
    + '주민번호<br>'
    +'	<input type="text" id="ssn" name="ssn"><br>'
    +'	전화번호<br>'
    +'	<input type="text" id="phone" name="phone"><br>'
    +'	도 시<br>'
    +'	<input type="text" id="city" name="city"><br>'
    + '주 소<br>'
    +'	<input type="text" id="address" name="address"><br>'
    +'	우편번호<br>'
    +'	<input type="text" id="postalcode" name="postalcode"><br>'
    +' <br><br>'
    +'	<input id="confirm-btn" type="submit" value="확인">'
    +'	<input id="cancel-btn" type="reset" value="취소">'
    +'</form>';
    }

function join(){
    let xhr = new XMLHttpRequest();
    let data = {
        customerId : document.getElementById('customerId').value,
        customerName : document.getElementById('customerName').value, 
        password : document.getElementById('password').value,
        ssn : document.getElementById('ssn').value,
        phone : document.getElementById('phone').value,
        city : document.getElementById('city').value,
        address : document.getElementById('address').value,
        postalcode : document.getElementById('postalcode').value,
    };

    xhr.open('POST','customers', true);
    xhr.setRequestHeader('Content-type','application/json; charset=UTF-8');
    xhr.onload=()=>{
        if(xhr.readyState===4 && xhr.status === 200) {
            let d = JSON.parse(xhr.responseText);
            if(d.result === 'SUCCESS'){
                alert('회원가입 성공 : ' + d.result);

            }else{
                alert('회원가입 실패');   
            }
        }else {
            alert('AJAX 실패')
        }
            
    };
    //data로 보내면 값이 DTO에 자동으로 들어가나?
    xhr.send(JSON.stringify(data));
};

function login_form(){
    return '<form>'
    +'  ID:<br>'
    +'  <input type="text" id="customerId" name="customerId">'
    +'  <br>'
    +'  PWD:<br>'
    +'  <input type="password" id="password" name="password">'
    +'  <br><br>'
    +'  <input id="login-btn" type="button" value="LOGIN">'
    +'  <input id="join-btn" type="button" value="JOIN">'
    +'</form> ';
};

function login(){
        alert('로그인 함수에 들어옴');
        id = document.getElementById('customerId').value;
        pass = document.getElementById('password').value;
    
        //1번으로 작동
        let xhr = new XMLHttpRequest();

        //2번
        xhr.open('GET', 'customers/'+id+'/'+pass, true);

        //3번 갔다와야 dto가 들어가 있을테니까? 변화가 있을때만 if함수가 실행됨. 콜백함수 리스너라고 함. 상태변화가 생기면 반응함.
        xhr.onload=()=>{
            //5번 (변화가 있을 시 들어옴)
            if(xhr.readyState=== 4 && xhr.status === 200){
                //d는 DTO임
                let d = JSON.parse(xhr.responseText);
                alert('로그인 성공 후' + d.customerName);
            
                if(d){
                    // $wrapper.innerHTML = customer.mypage_form(d);    //로그인 했던 정보를 보내줘서 보여주고, 수정 할때도 써야함.
                    
                    session.set_value({'name':'user',
                    'value':d
                });
                    customer.mypage(d);

                }else{
                    app.init();
                }
                
            }
        };
    
                //4번(보내줘야지 readyState가 들어올것.)
        xhr.send();
    };



function mypage(x){
    $wrapper.innerHTML = customer.mypage_form(x);

    document.getElementById('update-btn')
    .addEventListener('click', e=>{
        e.preventDefault();
        alert('세션 테스트' + session.get_value('user'));
        // customer.update(x);
    });
}

function mypage_form(x){
    let customer = x;
    return '<h1>'+customer.customerName+' 마이페이지</h1> <br>'
    +'아이디<br>'
    +'<span id="customerId">'+customer.customerId+'</span><br>'
    +'비밀번호<br>'
    +'	<span id="password">'+customer.password+'</span><br>'
    +'이 름<br>'
    +'<span id="customerName">'+customer.customerName+'</span>'
    +'주민번호<br>'
    +'<span id="ssn">'+customer.ssn+'</span>'
    +'전화번호<br>'
    +'	<span id="phone">'+customer.phone+'</span><br>'
    +'도 시<br>'
    +'	<span id="city">'+customer.city+'</span><br>'
    +'주 소<br>'
    +'	<span id="address">'+customer.address+'</span><br>'
    +'우편번호<br>'
    +'	<span id="postalcode">'+customer.postalcode+'</span><br>'
    +'<br><br>'
    +'	<input id="update-btn" type="button" value="수 정">'
    +'	<input id="remove-btn" type="button" value="탈 퇴">';
}

function update_form(x){
    return '<form>'
    +'아이디<br>'
    +'	<span id="customerId">'+x.customerId+'</span><br>'
    +'비밀번호<br>'
    +'	<input type="password" id="password" name="password" value="'+x.password+'"><br>'
    +'이 름<br>'
    +'	<span id="customerName">'+x.customerName+'</span><br>'
    +'주민번호<br>'
    +'	<span id="ssn">'+x.ssn+'</span><br>'
    +'전화번호<br>'
    +'	<input type="text" id="phone" name="phone" value="'+x.phone+'"><br>'
    +'도 시<br>'
    +'	<input type="text" id="city" name="city" value="'+x.city+'"><br>'
    +'주 소<br>'
    +'	<input type="text" id="address" name="address" value="'+x.address+'"><br>'
    +'우편번호<br>'
    +'	<input type="text" id="postalcode" name="postalcode" value="'+x.postalcode+'"><br>'
    +'<br><br>'
    +'	<input id="confirm-btn" type="submit" value="확 인">'
    +'	<input id="cancel-btn" type="reset" value="취 소">'
    +'</form>';
}

function update(x){
    let wrapper = document.querySelector('#wrapper');
    wrapper.innerHTML = customer.update_form(x);
    alert('수정할 아이디: '+ document.getElementById('customerId').innerText );
    document.getElementById('confirm-btn')
        .addEventListener('click', e=>{
            e.preventDefault();
            let data = {
                customerId : document.getElementById('customerId').innerText ,
                customerName : document.getElementById('customerName').innerText ,
                password : document.getElementById('password').value,
                ssn : document.getElementById('ssn').innerText ,
                phone : document.getElementById('phone').value,
                city : document.getElementById('city').value,
                address : document.getElementById('address').value,
                postalcode : document.getElementById('postalcode').value
            }
            let xhr = new XMLHttpRequest();
            xhr.open('PUT','customers/'+x.customerId,true);
            xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
            xhr.onload=()=>{
                if(xhr.readyState===4 && xhr.status === 200){
                    let d = JSON.parse(xhr.responseText);
                    customer.mypage(d);
                }
            };
            xhr.send(JSON.stringify(data));    
        });
    
    }

function remove(){
    let customerId = document.getElementById('customerId');
    let xhr = new XMLHttpRequest();
    xhr.open('delete','customers/'+customerId,true);
    xhr.onload=()=>{
        if(xhr.readyState===4 && xhr.status === 200){
            alert('성공');
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = '총 고객수 : <h1>'+xhr.responseText+'</h1>'
        }
    };
    xhr.send();
}



// function mypage(x){  
//     let xhr = new XMLHttpRequest();
//         let data = {
//             customerId : document.getElementById('customerId').value,
//             customerName : document.getElementById('customerName').value, 
//             password : document.getElementById('password').value,
//             ssn : document.getElementById('ssn').value,
//             phone : document.getElementById('phone').value,
//             city : document.getElementById('city').value,
//             address : document.getElementById('address').value,
//             postalcode : document.getElementById('postalcode').value,
//         };
//         console.log('ddddddd');
//         console.log(data);
    
//         xhr.open('PUT','customers/' + id, true);
//         xhr.setRequestHeader('Content-type','application/json; charset=UTF-8');
//         xhr.onload=()=>{
//             if(xhr.readyState===4 && xhr.status === 200) {
//                 let d = JSON.parse(xhr.responseText);
//                 if(d.result === 'SUCCESS'){
//                     alert('정보 변경 성공! : ' + d.result);
//                     //로그인 폼이 들어옴
    
//                     app.init();
    
//                 }else{
//                     alert('정보 변경 실패');   
//                 }
//             }else {
//                 alert('AJAX 실패')
//             }
                
//         };
//         //data로 보내면 값이 DTO에 자동으로 들어가나?
//         xhr.send(JSON.stringify(data));
    
    
    
//     };


