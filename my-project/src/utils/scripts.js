function handleSaveLayout() {
  var e = $(".demo").html()
  if (e != window.demoHtml) {
    window.demoHtml = e
  }
}
function handleJsIds() {
  handleModalIds()
  handleAccordionIds()
  handleCarouselIds()
  handleTabsIds()
}
function handleAccordionIds() {
  var e = $(".demo #myAccordion")
  var t = randomNumber()
  var n = "panel-" + t
  var r
  e.attr("id", n)
  e.find(".panel").each(function (e, t) {
    r = "panel-element-" + randomNumber()
    $(t).find(".panel-title").each(function (e, t) {
      $(t).attr("data-parent", "#" + n)
      $(t).attr("href", "#" + r)
    })
    $(t).find(".panel-collapse").each(function (e, t) {
      $(t).attr("id", r)
    })
  })
}
function handleCarouselIds() {
  var e = $(".demo #myCarousel")
  var t = randomNumber()
  var n = "carousel-" + t
  e.attr("id", n)
  e.find(".carousel-indicators li").each(function (e, t) {
    $(t).attr("data-target", "#" + n)
  })
  e.find(".left").attr("href", "#" + n)
  e.find(".right").attr("href", "#" + n)
}
function handleModalIds() {
  var e = $(".demo #myModalLink")
  var t = randomNumber()
  var n = "modal-container-" + t
  var r = "modal-" + t
  e.attr("id", r)
  e.attr("href", "#" + n)
  e.next().attr("id", n)
}
function handleTabsIds() {
  var e = $(".demo #myTabs")
  var t = randomNumber()
  var n = "tabs-" + t
  e.attr("id", n)
  e.find(".tab-pane").each(function (e, t) {
    var n = $(t).attr("id")
    var r = "panel-" + randomNumber()
    $(t).attr("id", r)
    $(t).parent().parent().find("a[href=#" + n + "]").attr("href", "#" + r)
  })
}
function randomNumber() {
  return randomFromInterval(1, 1e6)
}
function randomFromInterval(e, t) {
  return Math.floor(Math.random() * (t - e + 1) + e)
}
function gridSystemGenerator() {
  $(".lyrow .preview input").bind("keyup", function () {
    var e = 0
    var t = ""
    var n = false
    var r = $(this).val().split(" ", 12)
    $.each(r, function (r, i) {
      if (!n) {
        if (parseInt(i) <= 0) n = true
        e = e + parseInt(i)
        t += '<div class="col-md-' + i + ' column"></div>'
      }
    })
    if (e == 12 && !n) {
      $(this).parent().next().children().html(t)
      $(this).parent().prev().show()
    } else {
      $(this).parent().prev().hide()
    }
  })
}
function configurationElm(e, t) {
  $(".demo").delegate(".configuration > a", "click", function (e) {
    e.preventDefault()
    var t = $(this).parent().next().next().children()
    $(this).toggleClass("active")
    t.toggleClass($(this).attr("rel"))
  })
  $(".demo").delegate(".configuration .dropdown-menu a", "click", function (e) {
    e.preventDefault()
    var t = $(this).parent().parent()
    var n = t.parent().parent().next().next().children()
    t.find("li").removeClass("active")
    $(this).parent().addClass("active")
    var r = ""
    t.find("a").each(function () {
      r += $(this).attr("rel") + " "
    })
    t.parent().removeClass("open")
    n.removeClass(r)
    n.addClass($(this).attr("rel"))
  })
}
function removeElm(rootObj) {
  $(".demo").delegate(".remove", "click", function (e) {
    e.preventDefault()
    // 删除时获取对应组件id
    var cid = $(this).parent().find('[obj=component]').attr("cid")
    $(this).parent().remove()
    if (!$(".demo .lyrow").length > 0) {
      clearDemo()
    }
    if (cid) {
      // 删除window对象绑定组件对象
      delete window[cid]
      // 向当前视图子组件发送广播,删除对应组件实例，
      rootObj.$bus.$emit('on-deleteComponent', cid)
    }
  })
}
function clearDemo() {
  $(".demo").empty()
}
function removeMenuClasses() {
  $("#menu-layoutit li button").removeClass("active")
}
function changeStructure(e, t) {
  $("#download-layout ." + e).removeClass(e).addClass(t)
}
function cleanHtml(e) {
  $(e).parent().append($(e).children().html())
}
function downloadLayoutSrc() {
  var e = ""
  $("#download-layout").children().html($(".demo").html())
  var t = $("#download-layout").children()
  t.find(".preview, .configuration, .drag, .remove").remove()
  t.find(".lyrow").addClass("removeClean")
  t.find(".box-element").addClass("removeClean")
  t.find(".lyrow .lyrow .lyrow .lyrow .lyrow .removeClean").each(function () {
    cleanHtml(this)
  })
  t.find(".lyrow .lyrow .lyrow .lyrow .removeClean").each(function () {
    cleanHtml(this)
  })
  t.find(".lyrow .lyrow .lyrow .removeClean").each(function () {
    cleanHtml(this)
  })
  t.find(".lyrow .lyrow .removeClean").each(function () {
    cleanHtml(this)
  })
  t.find(".lyrow .removeClean").each(function () {
    cleanHtml(this)
  })
  t.find(".removeClean").each(function () {
    cleanHtml(this)
  })
  t.find(".removeClean").remove()
  $("#download-layout .column").removeClass("ui-sortable")
  $("#download-layout .row-fluid").removeClass("clearfix").children().removeClass("column")
  if ($("#download-layout .container").length > 0) {
    changeStructure("row-fluid", "row")
  }
  var formatSrc = $.htmlClean($("#download-layout").html(), {
    format: true,
    allowedAttributes: [
      ["id"],
      ["class"],
      ["data-toggle"],
      ["data-target"],
      ["data-parent"],
      ["role"],
      ["data-dismiss"],
      ["aria-labelledby"],
      ["aria-hidden"],
      ["data-slide-to"],
      ["data-slide"],
      ["cache"],
      ["obj"],
      ["ctype"]
    ]
  })
  // 保存download-layout上，给手机使用
  var componentObj = $("#download-layout").html(formatSrc).find('[obj=component]')
  console.log(componentObj.length)
  $("#download-layout").html(formatSrc).find('[obj=component]').each(function(){
    var cache = $(this).attr('cache')
    if(!cache){
      cache = ""
    }
    var ctype = $(this).attr('ctype')
    if(!ctype){
      ctype = ""
    }
    var tmp = $(this).replaceWith("<" + ctype + " cache=" + cache + ">" + "</" + ctype + ">")
  })
  $("#downloadModal textarea").empty()
  $("#downloadModal textarea").val($("#download-layout").html())

  // 保存到#save-layout 节点上，给pc使用
  //  var componentObj2 = $("#save-layout").html($(".demo").html())
  //  var componentObj3 =  componentObj2.find('[obj=component]')
  // componentObj3.replaceWith("<" + ctype + " cache=" + cache + ">" + "</" + ctype + ">")
  // var arrEntities={'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'}
  // var str = componentObj3.replace(/&(lt|gt|nbsp|amp|quot)/ig,function(all,t){return arrEntities[t]})
}
var currentDocument = null
var timerSave = 2e3
var demoHtml = $(".demo").html()
$(window).resize(function () {
  $("body").css("min-height", $(window).height() - 90)
  $(".demo").css("min-height", $(window).height() - 160)
})

function init (rootObj) {
  $("body").css("min-height", $(window).height() - 90)
  $(".demo").css("min-height", $(window).height() - 160)
  // $("[data-target=#downloadModal]").click(function (e) {
  //   e.preventDefault()
  //   downloadLayoutSrc()
  // })
  $("#download").click(function () {
    alert('download')
    downloadLayout()
    return false
  })
  $("#downloadhtml").click(function () {
    alert('downloadhtml')
    downloadHtmlLayout()
    return false
  })
  $("#edit").click(function () {
    $("body").removeClass("devpreview sourcepreview")
    $("body").addClass("edit")
    removeMenuClasses()
    $(this).addClass("active")
    return false
  })
  $("#clear").click(function (e) {
    e.preventDefault()
    clearDemo()
  })
  $("#devpreview").click(function () {
    $("body").removeClass("edit sourcepreview")
    $("body").addClass("devpreview")
    removeMenuClasses()
    $(this).addClass("active")
    return false
  })
  $("#sourcepreview").click(function () {
    $("body").removeClass("edit")
    $("body").addClass("devpreview sourcepreview")
    removeMenuClasses()
    $(this).addClass("active")
    return false
  })
  $(".nav-header").click(function () {
    $(".sidebar-nav .boxes, .sidebar-nav .rows").hide()
    $(this).next().slideDown()
  })

  removeElm(rootObj)
  configurationElm()
  gridSystemGenerator()
  // setInterval(function () {
  //   handleSaveLayout()
  // }, timerSave)
}
export {
  init,
  downloadLayoutSrc,
  clearDemo
}
