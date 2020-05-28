$("#search-open").on("click",function(){
    $(".search-overlay").toggleClass("expanded-mine");
    $(".search-overlay").toggleClass("collapsed-mine");
    $("body").css({
        "overflow":"hidden"
    })
})
$("#search-close").on("click",function(){
    $(".search-overlay").toggleClass("collapsed-mine");
    $(".search-overlay").toggleClass("expanded-mine");
    $("body").css({
        "overflow":"auto"
    })
})

$("#dropdown-menu").on("click",function(){
    $(".dropdown-box").toggleClass("down");
})


var flex = "flex";

$("#arrow-1").on("click",function(){
    $("#trainer-1").css(
        {
            "z-index":9999,
            width: "100vw",
            height: "100vh",
            display: flex
        }
    )
    $("body").css({
        "overflow":"hidden"
    })
})
$("#arrow-2").on("click",function(){
    $("#trainer-2").css(
        {
            "z-index":9999,
            width: "100vw",
            height: "100vh",
            display: flex
        }
    )
    $("body").css({
        "overflow":"hidden"
    })
})
$("#arrow-3").on("click",function(){
    $("#trainer-3").css(
        {
            "z-index":9999,
            width: "100vw",
            height: "100vh",
            display: flex
        }
    )
    $("body").css({
        "overflow":"hidden"
    })
})
$("#arrow-4").on("click",function(){
    $("#trainer-4").css(
        {
            "z-index":9999,
            width: "100vw",
            height: "100vh",
            display: flex
        }
    )
    $("body").css({
        "overflow":"hidden"
    })
})
$("#arrow-5").on("click",function(){
    $("#trainer-5").css(
        {
            "z-index":9999,
            width: "100vw",
            height: "100vh",
            display: flex
        }
    )
    $("body").css({
        "overflow":"hidden"
    })
})
$("#arrow-6").on("click",function(){
    $("#trainer-6").css(
        {
            "z-index":9999,
            width: "100vw",
            height: "100vh",
            display: flex
        }
    )
    $("body").css({
        "overflow":"hidden"
    })
})

$(".close-x").on("click",function(){
    $(".trainer-overlay").css(
        {
            display:"none"
        }
    )
    $("body").css({
        "overflow":"auto"
    })
})

