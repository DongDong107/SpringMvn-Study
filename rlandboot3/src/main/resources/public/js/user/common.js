/**
 * 작성일: 22.08.21
 * 작성자: h
 * version: 1
 *  공통 자바스크립트 코드
 *  */

function Dialog(){
    this.section = document.createElement("section");   
    document.body.append(this.section);

    this.oncancel = null;
    this.onok = null;
    this.onsend = null;
}

Dialog.prototype = {
    show : function(message, title){

    },
    confirm : function(message, title){
        
        var html = String.raw`<div class="rland_screen">
			    <div class="rland_dlg">
					<div class="rland_container">
						<div class="wrap-icon-close">
							<div class="icon icon-close">취소</div>
						</div>
			            <div class="rland_view">
			                ${message}
			            </div>
			            <div class="rland_action-panel">
			                <a href="" class="btn btn-cancel">닫기</a>
			                <a href="" class="btn btn-default">로그인</a>
			            </div>
					</div>
				</div>
			</div>`;

        this.section.insertAdjacentHTML("beforeend", html);

        // var screenDiv = this.section.querySelector(".rland_screen");
        // Object.assign(screenDiv.style, {
        //     backgroundColor:"#0008",
        //     position:"fixed"
        // });

        var style = document.createElement("style");
        style.textContent = `.rland_screen{
            background-color: #0008;
            /* opacity:.6; */
            position: fixed;
            left: 0;
            top:0;
            width:100vw;
            height: 100vh;
            z-index: 100;   
        
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        .rland_dlg{
            background-color: #fff;
            border-radius: 34px;

            position:relative;
            top:-100px;
            opacity : 0;

            transition: top .5s, opacity .5s;
        }

        .wrap-icon-close {
        	display: flex;
        	justify-content: flex-end;
        }

        .rland_dlg.show{
            top:0px;
            opacity: 1;
        }
        
        .rland_title{
            border-radius: 10px 10px 0 0;
            padding:10px;
            background-color: rgb(174, 218, 73);
            color:#fff;
        }
        
        .rland_container {
        	min-width: 270px;
        
        	padding: 24px 34px 34px 34px;
        	box-sizing: border-box;
        }
        
        .rland_view{
            padding: 20px;
            text-align: center;
        }
        .rland_action-panel{
            padding: 10px 10px ;
            display: flex;
            justify-content: center;
        }
        
        .rland_action-panel .btn-cancel {
        	margin-right: 4px;
        }
        
        .rland_action-panel .btn-cancel:hover {
        	background-color: var(--color-main-dark);
        	color: var(--color-text-invert);
        }
        
        .rland_action-panel .btn-default:hover {
            background-color: var(--color-text-invert);
        	color: var(--color-text-dark);
			border: solid 1px var(--color-main-dark);
        }
        
        .icon-close:hover {
        	cursor: pointer;
        }`;

        document.head.append(style);

        var dlgDiv = this.section.querySelector(".rland_dlg");
        
        setTimeout(function(){
            dlgDiv.classList.add("show");
        }, 0);
        
        var cancelButton = this.section.querySelector(".rland_action-panel .btn-cancel");
        var cancelBtn = this.section.querySelector(".rland_container .icon-close");
        var loginBtn = this.section.querySelector(".rland_container .btn-default");
        
        //var dlg = this;
        cancelButton.onclick = function(e){
            e.preventDefault();
            this.oncancel();
            this.section.remove();
        }.bind(this);
        
        //우측 상단 x 버튼 누를 경우
        cancelBtn.onclick = function(e){
        	e.preventDefault();
            this.oncancel();
            this.section.remove();
        }.bind(this);
        
        loginBtn.onclick = function(e){
            e.preventDefault();
            this.onsend();
            this.section.remove();
        }.bind(this);
        
        return true;
    }
};

// 한글(완성형)이 포함되었는지 여부
function containKOR(str) {
	var chk = /[가-힣]/g;
	if(chk.test(str)) {
		return true;
	} else {
		return false;
	}
}