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
        rememberMe: true,
        router: true,
    },
        baseUrl: "https://dev-22030587.okta.com",
        clientId: "0oau09w4fHXe11kvW5d6",
        authParams: {
        issuer: "https://https://dev-22030587.okta.com/oauth2/default"
    },
};

signInWidget = new OktaSignIn(signInWidgetConfig);
signInWidget.renderEl({el: '#widget-container'})

function logout() {
    signInWidget.authClient.signOut();
    location.href = '/home.html';
}