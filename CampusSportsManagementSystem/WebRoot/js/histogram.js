$(document).ready(function (){
	$.ajax({
        type: 'Post',
        url: 'collegehistogram.do',
        data: {},
        dataType: 'json',
        success: function (succ) {
        	if(succ.flag == 10001){
        	var chart = AmCharts.makeChart("chartdiv", {
        		  "type": "serial",
        		  "startDuration": 2,
        		  "dataProvider": succ.result1,
//        			  [{
//        		    "collegename": "信息工程学院",
//        		    "visits": 90,
//        		    "color": "#FF0F00"
//        		  }, {
//        		    "collegename": "会计学院",
//        		    "visits": 82,
//        		    "color": "#FF6600"
//        		  }], 
        		//  {
//        		    "collegename": "Japan",
//        		    "visits": 1809,
//        		    "color": "#FF9E01"
        		//  }, {
//        		    "collegename": "Germany",
//        		    "visits": 1322,
//        		    "color": "#FCD202"
        		//  }, {
//        		    "collegename": "UK",
//        		    "visits": 1122,
//        		    "color": "#F8FF01"
        		//  }, {
//        		    "collegename": "France",
//        		    "visits": 1114,
//        		    "color": "#B0DE09"
        		//  }, {
//        		    "collegename": "India",
//        		    "visits": 984,
//        		    "color": "#04D215"
        		//  }, {
//        		    "collegename": "Spain",
//        		    "visits": 711,
//        		    "color": "#0D8ECF"
        		//  }, {
//        		    "collegename": "Netherlands",
//        		    "visits": 665,
//        		    "color": "#0D52D1"
        		//  }, {
//        		    "collegename": "Russia",
//        		    "visits": 580,
//        		    "color": "#2A0CD0"
        		//  }, {
//        		    "collegename": "South Korea",
//        		    "visits": 443,
//        		    "color": "#8A0CCF"
        		//  }, {
//        		    "collegename": "Canada",
//        		    "visits": 441,
//        		    "color": "#CD0D74"
        		//  }, {
//        		    "collegename": "Brazil",
//        		    "visits": 395,
//        		    "color": "#754DEB"
        		//  }, {
//        		    "collegename": "Italy",
//        		    "visits": 386,
//        		    "color": "#DDDDDD"
        		//  }, {
//        		    "collegename": "Australia",
//        		    "visits": 384,
//        		    "color": "#999999"
        		//  }, {
//        		    "collegename": "Taiwan",
//        		    "visits": 338,
//        		    "color": "#333333"
        		//  }, {
//        		    "collegename": "Poland",
//        		    "visits": 328,
//        		    "color": "#000000"
        		//  }],
        		  "valueAxes": [{
        		    "position": "left",
        		    "axisAlpha": 0,
        		    "gridAlpha": 0
        		  }],
        		  "graphs": [{
        		    "balloonText": "[[category]]: <b>[[value]]</b>",
        		    "colorField": "color",
        		    "fillAlphas": 0.85,
        		    "lineAlpha": 0.1,
        		    "type": "column",
        		    "topRadius": 1,
        		    "valueField": "visits"
        		  }],
        		  "depth3D": 40,
        		  "angle": 30,
        		  "chartCursor": {
        		    "categoryBalloonEnabled": false,
        		    "cursorAlpha": 0,
        		    "zoomable": false
        		  },
        		  "categoryField": "collegename",
        		  "categoryAxis": {
        		    "gridPosition": "start",
        		    "axisAlpha": 0,
        		    "gridAlpha": 0

        		  },
        		  "exportConfig": {
        		    "menuTop": "20px",
        		    "menuRight": "20px",
        		    "menuItems": [{
        		      "icon": '/lib/3/images/export.png',
        		      "format": 'png'
        		    }]
        		  }
        		}, 0);
        	}else{
        		window.location.href="collegechievement.jsp"
        	}
        }
    });
})



//jQuery('.chart-input').off().on('input change', function() {
//  var property = jQuery(this).data('property');
//  var target = chart;
//  chart.startDuration = 0;
//
//  if (property == 'topRadius') {
//    target = chart.graphs[0];
//  }
//
//  target[property] = this.value;
//  chart.validateNow();
//});