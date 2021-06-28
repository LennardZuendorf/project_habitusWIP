signInWidgetConfig = {
    logo: src="/img/logo_long.svg",
    language: 'en',
    i18n: {
        'en': {
        'primaryauth.title': 'SIGN IN - powered by Okta',
        'primaryauth.submit': 'SUBMIT',
        }
    },
        // Changes to widget functionality
        features: {
        registration: true,
        rememberMe: true
    },
        baseUrl: "https://dev-22030587.okta.com",
        clientId: "0oa13n31xrIcmLIfg5d7",
        authParams: {
        issuer: "https://dev-22030587.okta.com/oauth2/default"
    },
};

signInWidget = new OktaSignIn(signInWidgetConfig);
signInWidget.renderEl({el: '#widget-container'})