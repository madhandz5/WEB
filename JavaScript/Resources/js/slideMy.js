var bannerStatus = 0;
var imgIdx = document.getElementById("imgWrapper").children;


window.onload = function () {
	this.bannerLoop();
}

document.getElementById("imgbanbtn-prev").onclick = function () {
	if (bannerStatus === 0) {
		bannerStatus = 2;
	} else if (bannerStatus === 1) {
		bannerStatus = 3;
	} else if (bannerStatus === 2) {
		bannerStatus = 0;
	} else if (bannerStatus === 3) {
		bannerStatus = 1;
	}
	bannerLoop();
}

document.getElementById("imgbanbtn-next").onclick = function () {
	bannerLoop();
}

document.querySelectorAll(".navbtnDiv").forEach(function (ele) {
	ele.addEventListener("click", function (e) {
		bannerStatus = (Number)(e.target.id.substring(4));
		bannerLoop();
	});
});

function bannerLoop() {
	if (bannerStatus === 0) {
		imgIdx[bannerStatus].style.opacity = "1";
		imgIdx[bannerStatus].style.right = "0px";
		imgIdx[bannerStatus].style.zIndex = "1000";
		imgIdx[bannerStatus + 1].style.opacity = "0";
		imgIdx[bannerStatus + 1].style.right = "-1200px";
		imgIdx[bannerStatus + 1].style.zIndex = "5";
		imgIdx[bannerStatus + 2].style.opacity = "0";
		imgIdx[bannerStatus + 2].style.right = "-2400px";
		imgIdx[bannerStatus + 2].style.zIndex = "5";
		imgIdx[bannerStatus + 3].style.opacity = "0";
		imgIdx[bannerStatus + 3].style.right = "1200px";
		imgIdx[bannerStatus + 3].style.zIndex = "5";
		document.querySelectorAll(".navbtn").forEach(function (v) {
			v.style.backgroundColor = "grey";
		});
		document.querySelector("#nb-0" + bannerStatus).style.backgroundColor = "red";
		bannerStatus = 1;
	}

	else if (bannerStatus === 1) {
		imgIdx[bannerStatus].style.opacity = "1";
		imgIdx[bannerStatus].style.right = "0px";
		imgIdx[bannerStatus].style.zIndex = "1000";
		imgIdx[bannerStatus + 1].style.opacity = "0";
		imgIdx[bannerStatus + 1].style.right = "-1200px";
		imgIdx[bannerStatus + 1].style.zIndex = "5";
		imgIdx[bannerStatus + 2].style.opacity = "0";
		imgIdx[bannerStatus + 2].style.right = "-2400px";
		imgIdx[bannerStatus + 2].style.zIndex = "5";
		imgIdx[bannerStatus - 1].style.opacity = "0";
		imgIdx[bannerStatus - 1].style.right = "1200px";
		imgIdx[bannerStatus - 1].style.zIndex = "5";
		document.querySelectorAll(".navbtn").forEach(function (v) {
			v.style.backgroundColor = "grey";
		});
		document.querySelector("#nb-0" + bannerStatus).style.backgroundColor = "red";
		bannerStatus = 2;
	}

	else if (bannerStatus === 2) {
		imgIdx[bannerStatus].style.opacity = "1";
		imgIdx[bannerStatus].style.right = "0px";
		imgIdx[bannerStatus].style.zIndex = "1000";
		imgIdx[bannerStatus + 1].style.opacity = "0";
		imgIdx[bannerStatus + 1].style.right = "-1200px";
		imgIdx[bannerStatus + 1].style.zIndex = "5";
		imgIdx[bannerStatus - 2].style.opacity = "0";
		imgIdx[bannerStatus - 2].style.right = "-2400px";
		imgIdx[bannerStatus - 2].style.zIndex = "5";
		imgIdx[bannerStatus - 1].style.opacity = "0";
		imgIdx[bannerStatus - 1].style.right = "1200px";
		imgIdx[bannerStatus - 1].style.zIndex = "5";
		document.querySelectorAll(".navbtn").forEach(function (v) {
			v.style.backgroundColor = "grey";
		});
		document.querySelector("#nb-0" + bannerStatus).style.backgroundColor = "red";
		bannerStatus = 3;
	}
	else if (bannerStatus === 3) {
		imgIdx[bannerStatus].style.opacity = "1";
		imgIdx[bannerStatus].style.right = "0px";
		imgIdx[bannerStatus].style.zIndex = "1000";
		imgIdx[bannerStatus - 3].style.opacity = "0";
		imgIdx[bannerStatus - 3].style.right = "-1200px";
		imgIdx[bannerStatus - 3].style.zIndex = "5";
		imgIdx[bannerStatus - 2].style.opacity = "0";
		imgIdx[bannerStatus - 2].style.right = "-2400px";
		imgIdx[bannerStatus - 2].style.zIndex = "5";
		imgIdx[bannerStatus - 1].style.opacity = "0";
		imgIdx[bannerStatus - 1].style.right = "1200px";
		imgIdx[bannerStatus - 1].style.zIndex = "5";
		document.querySelectorAll(".navbtn").forEach(function (v) {
			v.style.backgroundColor = "grey";
		});
		document.querySelector("#nb-0" + bannerStatus).style.backgroundColor = "red";
		bannerStatus = 0;
	}
}