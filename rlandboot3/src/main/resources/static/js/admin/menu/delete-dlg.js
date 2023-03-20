/* jshint esversion : 6 */

export default class DeleteDlg {
    #section;
    #title;
    #acceptHref;
    #cancelHref;
    #acceptBtn;
    #cancelBtn;
	

    constructor(params) {
		console.log("open");
        this.#section = document.createElement("section");
        document.body.append(this.#section);
        this.#section.classList.add("delete-dlg");

        if(typeof params == "string") {
            this.#title = arguments[0];

            // 확인/취소 버튼
            this.#acceptBtn = arguments[1];
            this.#cancelBtn = arguments[2];

            // 확인/취소버튼 링크
            this.#acceptHref = arguments[3];
            this.#cancelHref = arguments[4];

        }

		this.onconfirm = null;
    }


    open() {
        const html = `<h1 class="d-none">대화상자</h1>
    

        <div class="dlg">
            
            <div class="box-icon-close">
                <div class="icon icon-close">닫기</div>
            </div>

            <p>${this.#title}</p>
            
            <div class="box-btn">
                <a class="btn btn-cancel" href="${this.#cancelHref}">${this.#cancelBtn}</a>
                <a class="btn btn-default btn-accept" href="${this.#acceptHref}">${this.#acceptBtn}</a>
            </div>
        </div>`;

        this.#section.insertAdjacentHTML("beforeend", html);
        const style = document.createElement("style");
        
        style.textContent = `
        
            /* ====== btn style ==================================================== */
            .delete-dlg .btn-accept {
                /* layout */
                padding: 0.5em 2em;
            }
            
            
            
            /* ====== outer block ================================================== */
            .delete-dlg {
                /* layout */
                width:100vw;
                height: 100vh;
                position: fixed;
				top: 0;
                z-index: 100;   
                background: rgba(0, 0, 0, 0.82);
                display: flex;
                justify-content: center;
                align-items: center;
            }
            
            .delete-dlg .dlg {
                /* layout */
                min-width: 270px;
                padding: 20px 22px 50px 22px;
                background-color: var(--color-bg-white);
                border-radius: 30px;
                box-sizing: border-box;
                position: relative;
                top: -100px;
                
                /* item layout */
                display: flex;
                flex-direction: column;

                /* effect */
                opacity: 0;
				transition: .7s;
            }

            .delete-dlg .dlg.show {
                top: 0px;
                opacity: 1;
            }
            
            .delete-dlg .dlg .box-icon-close  {
                display: flex;
                justify-content: end;
            }

            .delete-dlg .dlg p {
                margin-top: 30px;
            }
            
            .delete-dlg .dlg .box-btn {
                margin-top: 30px;
            }

            .delete-dlg .icon-close:hover {
                cursor: pointer;
            }
            
            .delete-dlg .box-btn {
                width: 100%;
                display: flex;
                justify-content: space-evenly;
            }
            
            
            /* ======= content block =============================================== */
            
            .delete-dlg p {
                /* text */
                font-family: 'Segoe UI';
                font-size: var(--font-size-title1);
                font-weight: normal;
                color: var(--color-bg-dark);
                text-align: center;
            
                /* layout */
                margin-top: 20px;
            }

            @media screen and (min-width: 768px) {

                /* ====== btn style ==================================================== */

                .delete-dlg .btn {
                    /* layout */
                    padding: 0.7em 2.5em;
                    border-radius: 0;
                }


                .delete-dlg .btn-accept {
                    /* layout */
                    padding: 0.7em 3.6em;
                }

                /* ====== outer block ================================================== */

                .delete-dlg .dlg {
                    min-width: 414px;
                    border-radius: 0px;
                    padding: 27px 22px 76px 54px;
                }
            
                .delete-dlg .dlg .box-btn {
                    margin-top: 38px;
                }
                
            }
        `;

        document.head.append(style);    // head에 style 태그 추가

        const box = this.#section.querySelector(".dlg");

        setTimeout(() => {
            box.classList.add("show");
        }, 0);

        const acceptBtn = box.querySelector(".btn-accept");

        // 확인 버튼
        acceptBtn.onclick = function(e) {
            if(this.#acceptHref == "")
                e.preventDefault();

			this.onconfirm();
            this.#section.remove();
        }.bind(this);

        const cancelBtn = box.querySelector(".btn-cancel");

		// 취소 버튼
        cancelBtn.onclick = function(e) {
            if(this.#cancelHref == "")
                e.preventDefault();
            
            this.#section.remove();
        }.bind(this);

		const boxIcon = document.querySelector(".box-icon-close");
		const closeIcon = boxIcon.querySelector(".icon-close");
		
		// 닫기 아이콘
		closeIcon.onclick = function(e) {
			this.#section.remove();
		}.bind(this);
    }
}