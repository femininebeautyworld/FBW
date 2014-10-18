$(document).ready(function() {
	
	/*
    $('.header_menu li').hover(
        function () {
            $('ul:first', this).css('display','block');
        }, 
        function () {
            $('ul:first', this).css('display','none');         
        }
    );  
	*/
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
	    
	$('#main_header_menu').slicknav();
	    
	if($('#header').css('position') == 'absolute')
		$('#header').css('top', $('.slicknav_menu').outerHeight() + 'px');
	else
		$('#header').css('top', '0px');                 				
    $("#stalac_cont").gridalicious({
        gutter: 30,
        width: 350,
        animate: true,
        animationOptions: {
                speed: 150,
                duration: 500,
                complete: onComplete
        },
    });    
    // function not used. 
    function onComplete(data) {
    }    
/*
    $('.stalac_box').hover(
    	function() {
    		$(this).find('.stalac_box_hover').css('display','block');
    	},
    	function() {
    		$(this).find('.stalac_box_hover').css('display','none');
    	}
    );
  */
	$("#home_cont").on("mouseenter", "#stalac_cont .stalac_box", function(event){
		$(this).find('.stalac_box_hover').css('display','block');
	}).on("mouseleave", "#stalac_cont .stalac_box", function(event){
		$(this).find('.stalac_box_hover').css('display','none');
	});  
    //#stalac_cont
/*
	$("#stalac_cont").stalactite({
		duration: 350,                        // Duration of animation.
		easing: 'swing',                      // Easing method.
		cssPrefix: '.stalactite',             // The css naming convention.
		cssPrep: true,                        // Should stalactite structurally modify css of children?
		fluid: true,                          // Should stalactite recalculate on window resize?
//		loader: '<img />',                    // The contents of the loader. Defaults to a dataURL animated gif.
		styles: {},                            // A style object to place on the child elements
		complete: function(v) { return v; }  // Callback function
	});    
*/
	/*$('#stalac_cont').stalactite();*/
	    
	$('.archive_box_media').hover(
		function() {
			$(this).find('.archive_box_hover').css('display','block');
		},
		function() {
			$(this).find('.archive_box_hover').css('display','none');
		}
	);
	    
	    
});
$(window).load(function() {
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
});
$(window).scroll(function() {
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
	if($('#header').css('position') == 'absolute')
		$('#header').css('top', $('.slicknav_menu').outerHeight() + 'px');
	else
		$('#header').css('top', '0px');
	
});
$(window).resize(function() {
	$('.header_spacing').css('height', $('#header').outerHeight() + 'px');
	if($('#header').css('position') == 'absolute')
		$('#header').css('top', $('.slicknav_menu').outerHeight() + 'px');
	else
		$('#header').css('top', '0px');
});