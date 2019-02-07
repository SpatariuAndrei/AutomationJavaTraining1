<#ftl strip_whitespace=true>
<#macro renderStat stats name class=""><#assign value = stats.get(name)!0><#if (value != 0)><span class="${class}">${value}</span><#else>${value}</#if></#macro>
<#macro renderMillis stats name class=""><#assign millis = stats.get(name)!0><span class="${class}"><#assign time = timeFormatter.formatMillis(millis)>${time}</span></#macro>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>JBehave Reports</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style type="text/css" media="all">
@import url( "./style/custom-reports.css" );
</style>
</head>

<#assign NOT_FOUND = "Unable to find">

<#assign stats = reportsTable.getReport("Totals").getStats()>
<#assign scenarioCount = stats.get("scenarios")!0>
<#assign scenarioPassCount = stats.get("scenariosSuccessful")!0>
<#if scenarioPassCount == scenarioCount>
	<#assign scenarioSuccessClass = "successful">
<#else>
	<#assign scenarioSuccessClass = "failed">
</#if>
<#if scenarioCount == 0>
	<#assign scenarioSuccessPercentage = 0>
<#else>
	<#assign scenarioSuccessPercentage = scenarioPassCount * 100.0 / scenarioCount>
</#if>


<body>
<div id="header">
	<div id="logo">
		<img src="images/wp_logo.jpg" alt="WorldPay logo" />
	</div>
	<div id="details">
		<h2>Details</h2>
		
		<span class="detail">Scenarios Passed:</span> <span class="${scenarioSuccessClass}">${scenarioPassCount} / ${scenarioCount} (${scenarioSuccessPercentage}%)</span><br/>
		<br/>
		<span class="detail">Server host:</span> ${server!NOT_FOUND}<br/>
		<br/>
		<span class="detail">Server version:</span> ${version!NOT_FOUND}<br/>
		<br/>		
		<span class="detail">Generated on:</span> ${date?string("dd/MM/yyyy HH:mm:ss")}<br/>
	</div>
	<div class="clear"></div>
</div>

<div class="reports">

<h2>Story Reports</h2>

<table>
<colgroup span="2" class="stories"></colgroup>
<colgroup span="5" class="scenarios"></colgroup>
<colgroup span="5" class="scenarios"></colgroup>
<colgroup span="6" class="steps"></colgroup>
<colgroup class="view"></colgroup>
<tr>
    <th colspan="2">Stories</th>
    <th colspan="5">Scenarios</th>
    <th colspan="5">GivenStory Scenarios</th>
    <th colspan="6">Steps</th>
    <th></th>
    <th></th>
</tr>
<tr>
    <th>Name</th>
    <th>Excluded</th>
    <th>Total</th>
    <th>Successful</th>
    <th>Pending</th>
    <th>Failed</th>
    <th>Excluded</th>
    <th>Total</th>
    <th>Successful</th>
    <th>Pending</th>
    <th>Failed</th>
    <th>Excluded</th>
    <th>Total</th>
    <th>Successful</th>
    <th>Pending</th>
    <th>Failed</th>
    <th>Not Performed</th>
    <th>Ignorable</th>
    <th>Duration (hh:mm:ss.SSS)</th>
    <th>View</th>
</tr>
<#assign reportNames = reportsTable.getReportNames()>
<#assign totalReports = reportNames.size() - 1>
<#list reportNames as name>
<#assign report = reportsTable.getReport(name)>
<#if name != "Totals">
<tr>
<#assign stats = report.getStats()>
<#assign stepsFailed = stats.get("stepsFailed")!0>
<#assign scenariosFailed = stats.get("scenariosFailed")!0>
<#assign pending = stats.get("pending")!0>
<#assign storyClass = "story">
<#if stepsFailed != 0 || scenariosFailed != 0>
    <#assign storyClass = storyClass + " failed">
<#elseif pending != 0>
    <#assign storyClass = storyClass + " pending">
<#else>
    <#assign storyClass = storyClass + " successful">
</#if>
<td class="${storyClass}">${report.name}</td>
<td>
<@renderStat stats "notAllowed" "failed"/>
</td>
<td>
<@renderStat stats "scenarios"/> 
</td>
<td>
<@renderStat stats "scenariosSuccessful" "successful"/> 
</td>
<td>
<@renderStat stats "scenariosPending" "pending"/> 
</td>
<td>
<@renderStat stats "scenariosFailed" "failed"/>
</td>
<td>
<@renderStat stats "scenariosNotAllowed" "failed"/>
</td>
<td>
<@renderStat stats "givenStoryScenarios"/> 
</td>
<td>
<@renderStat stats "givenStoryScenariosSuccessful" "successful"/> 
</td>
<td>
<@renderStat stats "givenStoryScenariosPending" "pending"/> 
</td>
<td>
<@renderStat stats "givenStoryScenariosFailed" "failed"/>
</td>
<td>
<@renderStat stats "givenStoryScenariosNotAllowed" "failed"/>
</td>
<td>
<@renderStat stats "steps" />
</td>
<td>
<@renderStat stats "stepsSuccessful" "successful"/>
</td>
<td>
<@renderStat stats "stepsPending" "pending"/>
</td>
<td>
<@renderStat stats "stepsFailed" "failed"/>
</td>
<td>
<@renderStat stats "stepsNotPerformed" "notPerformed" />
</td>
<td>
<@renderStat stats "stepsIgnorable" "ignorable"/>
</td>
<td>
<@renderMillis stats "duration"/>
</td>
<td>
<#assign filesByFormat = report.filesByFormat>
<#list filesByFormat.keySet() as format><#assign file = filesByFormat.get(format)><a href="${file.name}">${format}</a><#if format_has_next> |</#if></#list>
</td>
</tr>
</#if>
</#list>
<tr class="totals">
<td>${totalReports}</td>
<#assign stats = reportsTable.getReport("Totals").getStats()>
<td>
<@renderStat stats "notAllowed" "failed"/>
</td>
<td>
<@renderStat stats "scenarios"/> 
</td>
<td>
<@renderStat stats "scenariosSuccessful" "successful"/> 
</td>
<td>
<@renderStat stats "scenariosPending" "pending"/> 
</td>
<td>
<@renderStat stats "scenariosFailed" "failed"/>
</td>
<td>
<@renderStat stats "scenariosNotAllowed" "failed"/>
</td>
<td>
<@renderStat stats "givenStoryScenarios"/> 
</td>
<td>
<@renderStat stats "givenStoryScenariosSuccessful" "successful"/> 
</td>
<td>
<@renderStat stats "givenStoryScenariosPending" "pending"/> 
</td>
<td>
<@renderStat stats "givenStoryScenariosFailed" "failed"/>
</td>
<td>
<@renderStat stats "givenStoryScenariosNotAllowed" "failed"/>
</td>
<td>
<@renderStat stats "steps" />
</td>
<td>
<@renderStat stats "stepsSuccessful" "successful"/>
</td>
<td>
<@renderStat stats "stepsPending" "pending"/>
</td>
<td>
<@renderStat stats "stepsFailed" "failed"/>
</td>
<td>
<@renderStat stats "stepsNotPerformed" "notPerformed" />
</td>
<td>
<@renderStat stats "stepsIgnorable" "ignorable"/>
</td>
<td>
<@renderMillis stats "duration"/>
</td>
<td>
Totals
</td>
</tr>
</table>
<br />
</div>

</body>

</html>