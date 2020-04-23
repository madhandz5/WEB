(function () {
	/* onscroll */

	function $(selector) {
		return document.querySelector(selector);
	}

	function $All(selector) {
		return document.querySelectorAll(selector);
	}

	window.onscroll = function () {
		var bodyHeight = $("body").clientHeight;
		if ($(".wrapper").clientHeight <= bodyHeight) {
			jsAjax();
		} else if (window.scrollY > $(".wrapper").clientHeight - bodyHeight) {
			jsAjax();
		}
	}

});


