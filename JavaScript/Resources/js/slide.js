var idx = 0;


function slideSelector(idx) {
	var elList = document.querySelectorAll(".slideBox div");
	elList.forEach(function (v) {
		v.style.transform = "translateX(" + (-idx * 100) + "%)";
		v.style.transitionDuration = "1s";

		document.querySelectorAll(".navButton").forEach(function (v) {
			v.style.backgroundColor = "white";
		});
		document.querySelector("#nb-0" + idx).style.backgroundColor = "red";
	});
}

document.querySelectorAll(".navButton").forEach(function (ele) {
	ele.addEventListener("click", function (e) {
		idx = e.target.id.substring(4);
		slideSelector(idx, ele);
	});
});

document.querySelector(".left").addEventListener("click", function () {
	if (idx == 0) {
		idx = 4;
	}
	slideSelector(--idx);
});

document.querySelector(".right").addEventListener("click", function () {
	if (idx == 3) {
		idx = -1;
	}
	slideSelector(++idx);
});
