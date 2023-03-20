window.addEventListener("load", function(){
    var canvas = document.querySelector(".game-canvas");    
    /* 집단지성 */
    /** @type {CanvasRenderingContext2D} */
    var ctx = canvas.getContext("2d");

    function Boy(){
        this.ix = 1;
        this.iy = 2;

        // 이건 이제 우리가 손대는 것이 아님.
        this.sw = 106;
        this.sh = 148.25;
        this.sx = this.sw*this.ix; //sw*0, sw*1, sw*2
        this.sy = this.sh*this.iy;
    }
    Boy.prototype = {
        draw:function(ctx){
            var img = new Image();
            img.src = "./image/boy.png";
            img.onload = function(){                
                ctx.drawImage(img, 
                        this.sx,this.sy,this.sw,this.sh,
                        200,100,106,148.25);
            }
        }
    };
    
    var boy1 = new Boy();
    boy1.draw(ctx);

    // //var img = this.document.querySelector("img");
    // var img = new Image();
    // img.src = "./image/boy.png";
    // img.onload = function(){
    //     //ctx.drawImage(img, 100,100);
    //     //ctx.drawImage(img, 100, 100, 106, 148.25);

    //     var ix = 1;
    //     var iy = 2;

    //     // 이건 이제 우리가 손대는 것이 아님.
    //     var sw = 106;
    //     var sh = 148.25;
    //     var sx = sw*ix; //sw*0, sw*1, sw*2
    //     var sy = sh*iy;

    //     ctx.drawImage(img, 
    //         sx,sy,sw,sh,
    //         200,100,106,148.25);
    // }

    
    
    


});