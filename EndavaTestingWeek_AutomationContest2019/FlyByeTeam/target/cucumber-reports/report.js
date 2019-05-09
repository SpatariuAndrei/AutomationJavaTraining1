$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/cucumber/sdk/features/FailingTests.feature");
formatter.feature({
  "line": 1,
  "name": "FAILING TESTS",
  "description": "",
  "id": "failing-tests",
  "keyword": "Feature"
});
formatter.before({
  "duration": 25676921551,
  "status": "passed"
});
formatter.before({
  "duration": 34149,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Fail a test to generate report",
  "description": "",
  "id": "failing-tests;fail-a-test-to-generate-report",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is in Modules View",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User selects IBS Module",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "User makes a successful login",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User validates that correct data is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Received MConnect credentials \"normalPay\" can be used for login",
  "keyword": "Then "
});
formatter.match({
  "location": "PaymentModuleSteps.userIsInModulesView()"
});
formatter.result({
  "duration": 138230999,
  "status": "passed"
});
formatter.match({
  "location": "IBSModuleSteps.userSelectsIBSModule()"
});
formatter.result({
  "duration": 3434258692,
  "status": "passed"
});
formatter.match({
  "location": "IBSModuleSteps.userMakesASuccessfulLogin()"
});
formatter.result({
  "duration": 6102318188,
  "status": "passed"
});
formatter.match({
  "location": "IBSModuleSteps.userValidatesThatCorrectDataIsDisplayed()"
});
formatter.result({
  "duration": 1366016717,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "normalPay",
      "offset": 31
    }
  ],
  "location": "PaymentModuleSteps.receivedMConnectCredentialsCanBeUsedForLogin(String)"
});
formatter.result({
  "duration": 96730962,
  "error_message": "java.net.UnknownHostException: portal.inflight-wifi.com: nodename nor servname provided, or not known\n\tat java.net.Inet6AddressImpl.lookupAllHostAddr(Native Method)\n\tat java.net.InetAddress$2.lookupAllHostAddr(InetAddress.java:928)\n\tat java.net.InetAddress.getAddressesFromNameService(InetAddress.java:1323)\n\tat java.net.InetAddress.getAllByName0(InetAddress.java:1276)\n\tat java.net.InetAddress.getAllByName(InetAddress.java:1192)\n\tat java.net.InetAddress.getAllByName(InetAddress.java:1126)\n\tat okhttp3.Dns$1.lookup(Dns.java:40)\n\tat okhttp3.internal.connection.RouteSelector.resetNextInetSocketAddress(RouteSelector.java:185)\n\tat okhttp3.internal.connection.RouteSelector.nextProxy(RouteSelector.java:149)\n\tat okhttp3.internal.connection.RouteSelector.next(RouteSelector.java:84)\n\tat okhttp3.internal.connection.StreamAllocation.findConnection(StreamAllocation.java:214)\n\tat okhttp3.internal.connection.StreamAllocation.findHealthyConnection(StreamAllocation.java:135)\n\tat okhttp3.internal.connection.StreamAllocation.newStream(StreamAllocation.java:114)\n\tat okhttp3.internal.connection.ConnectInterceptor.intercept(ConnectInterceptor.java:42)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\n\tat okhttp3.internal.cache.CacheInterceptor.intercept(CacheInterceptor.java:93)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\n\tat okhttp3.internal.http.BridgeInterceptor.intercept(BridgeInterceptor.java:93)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(RetryAndFollowUpInterceptor.java:126)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:147)\n\tat okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:121)\n\tat okhttp3.RealCall.getResponseWithInterceptorChain(RealCall.java:200)\n\tat okhttp3.RealCall.execute(RealCall.java:77)\n\tat api.apps.sdk.inflight.endava.com.payment.module.interfaces.M3handlerPayment.createSession(M3handlerPayment.java:55)\n\tat api.apps.sdk.inflight.endava.com.payment.module.interfaces.M3handlerPayment.getSessionId(M3handlerPayment.java:86)\n\tat api.apps.sdk.inflight.endava.com.payment.module.interfaces.M3handlerPayment.getLoginWithReceivedM3Cred(M3handlerPayment.java:66)\n\tat api.apps.sdk.inflight.endava.com.payment.module.interfaces.M3handlerPayment.loggedInMessageFromM3(M3handlerPayment.java:122)\n\tat api.apps.sdk.inflight.endava.com.payment.module.interfaces.M3handlerPayment.validateM3SuccessLogin(M3handlerPayment.java:81)\n\tat api.apps.sdk.inflight.endava.com.payment.module.PaymentManager.validateM3LoginWithReceivedCredentials(PaymentManager.java:41)\n\tat cucumber.sdk.tests.PaymentModuleSteps.receivedMConnectCredentialsCanBeUsedForLogin(PaymentModuleSteps.java:41)\n\tat ✽.Then Received MConnect credentials \"normalPay\" can be used for login(src/test/java/cucumber/sdk/features/FailingTests.feature:8)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 4046730736,
  "status": "passed"
});
formatter.after({
  "duration": 26963,
  "status": "passed"
});
});