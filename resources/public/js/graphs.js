queue()
    .defer(d3.json, "/data")
    .await(makeGraphs);

function makeGraphs(error, newsJson) {
	
	//Clean projectsJson data
	var news = newsJson;
	var dateFormat = d3.time.format("%Y-%m-%d");
	news.forEach(function(d) {
		d["date_posted"] = dateFormat.parse(d["year" "month" "day"]);
		d["total_reactions"] = +d["total_reactions"];
	});

	//Create a Crossfilter instance
	var ndx = crossfilter(news);

	//Define Dimensions
	var dateDim = ndx.dimension(function(d) { return d["date_posted"]; });
	var sectionDim = ndx.dimension(function(d) { return d["section"]; });
	

	//Calculate metrics
	var numArticlesByDate = dateDim.group(); 
	var numProjectsBySection = resourceTypeDim.group();
	var totalReactionsBySection = sectionDim.group().reduceSum(function(d) {
		return d["total_reactions"];
	});

	var all = ndx.groupAll();
	var totalReactions = ndx.groupAll().reduceSum(function(d) {return d["total_reactions"];});

	var max_section = totalReactionsByState.top(1)[0].value;

	//Define values (to be used in charts)
	var minDate = dateDim.bottom(1)[0]["date_posted"];
	var maxDate = dateDim.top(1)[0]["date_posted"];

    //Charts
	var timeChart = dc.barChart("#time-chart");
	var sectionTypeChart = dc.rowChart("#section-type-row-chart");
	var numberArticlesND = dc.numberDisplay("#number-articles-nd");
	var totalReactionsND = dc.numberDisplay("#total-reactions-nd");

	numberArticlesND
		.formatNumber(d3.format("d"))
		.valueAccessor(function(d){return d; })
		.group(all);

	totalReactionsND
		.formatNumber(d3.format("d"))
		.valueAccessor(function(d){return d; })
		.group(totalReactions)
		.formatNumber(d3.format(".3s"));

	timeChart
		.width(600)
		.height(160)
		.margins({top: 10, right: 50, bottom: 30, left: 50})
		.dimension(dateDim)
		.group(numArticlesByDate)
		.transitionDuration(500)
		.x(d3.time.scale().domain([minDate, maxDate]))
		.elasticY(true)
		.xAxisLabel("Year")
		.yAxis().ticks(4);

	resourceTypeChart
        .width(300)
        .height(250)
        .dimension(sectionDim)
        .group(numArticlesBySection)
        .xAxis().ticks(4);

	

    dc.renderAll();

};
