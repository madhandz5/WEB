
/* onscroll */
var pageId = 0;
var jo = 'url(../Image/jo.jpg)'

function $(selector) {
	return document.querySelector(selector);
}

function addInnerIU(pageId) {
	var innerIU = document.createElement("div");
	innerIU.setAttribute("class", "IU1");
	$("#IU" + pageId).appendChild(innerIU);
	if (pageId % 2 == 1) {
		innerIU.style.backgroundImage = jo;
	}
}

function addOuterIU(pageId) {
	var newIU = document.createElement("div");
	newIU.setAttribute("id", "IU" + pageId);
	$(".wrapper").appendChild(newIU);
}

window.onscroll = function () {
	var bodyHeight = $("body").clientHeight;
	if ($("#IU" + pageId).clientHeight <= bodyHeight) {
		addInnerIU(pageId);
	} else if (window.scrollY > $("#wrapper").clientHeight - bodyHeight) {
		pageId++;
		addOuterIU(pageId);
		addInnerIU(pageId);
	}
}


