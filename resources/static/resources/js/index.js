alert('자바스크립트 연결 성공!!');

// wrapper은 객체/. index.html 전체는 하나의 Dom 나머지는 컴포넌트로 처리할것임. <div id="wrapper"> <- 컴포넌트임.


var wrapper = document.querySelector("#wrapper");
wrapper.innerHTML = '<h1>SPA 시작</h1>'
+'<div id="target">삭제할 내용</div>'
+'<button id="btn">지워버리자ddd</button>'
+'<button id="btn2">추가하자</button>';

// 아래는 객체임. 컴포넌트.
var btn = document.querySelector('#btn');
var target = document.getElementById('target');

btn.addEventListener('click', function(){
    target.innerHTML = '';
});

var btn2 = document.querySelector('#btn2');

btn2.addEventListener('click', function() {
    var temp = document.creatTextNode('새로 추가 됨');
    target.appendChild(temp);
});


