$(document).ready(function(){
	$('#datepicker-container input').datepicker({
	    format: "dd.mm.yyyy",
	    weekStart: 1,
	    maxViewMode: 2,
	    todayBtn: "linked",
	    language: "de",
	    icons: {
	    	time: 'fa fa-clock-o',
	    	date: 'fa fa-calendar',
	    	up: 'fa fa-plus',
	    	down: 'fa fa-minus',
	    	next: 'fa fa-chevron-left',
	    	previous: 'fa fa-chevron-right'
	    	}
	});
})