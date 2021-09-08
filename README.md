
# Auth0-SpringBoot-multiple-social-login
Developer profile cards as part of Hashnode's Auth0 hackathon, built in SpringBoot. [LinkedIn, StackOverflow, Github]

Make sure to update application.yml with your client id and secret and use your custom namespace.

https://vivekdh45.hashnode.dev/auth0-spring-boot-social-login-with-custom-authentication-provider-linkedin-github-stackoverflow

## Configuration

### Auth0 Dashboard
1. On the [Auth0 Dashboard](https://manage.auth0.com/#/clients) create a new Application of type **Regular Web Application**.
1. On the **Settings** tab of your application, add the URL `http://localhost:3000/login/oauth2/code/auth0` to the **Allowed Callback URLs** field.
1. On the **Settings** tab of your application, add the URL `http://localhost:3000/` to the **Allowed Logout URLs** field.
1. Save the changes to your application settings. Don't close this page; you'll need some of the settings when configuring the application below.

### Application configuration

Copy `src/main/resources/application.yml.example` to `src/main/resources/application.yml`:

```bash
cp src/main/resources/application.yml.example src/main/resources/application.yml
```

Set the application values in the `src/main/resources/application.yml` file to the values of your Auth0 application.

```yaml
client-id: {YOUR-CLIENT-ID}
client-secret: {YOUR-CLIENT-SECRET}
issuer-uri: https://{YOUR-DOMAIN}/
```

### Running the sample

Open a terminal, go to the project root directory and run the following command:

Linux or MacOS:

```bash
./gradlew bootRun
```

Windows:

```bash
gradlew.bat bootRun 
```

The application will be accessible at http://localhost:3000.

### Running the sample with docker

In order to run the example with [Docker](https://docs.docker.com/install/) you need to have `docker` installed.

You also need to set the client values as explained [previously](#application-configuration).

Execute the command to run Docker for your environment:

Linux or MacOS:

```bash
sh exec.sh
```

Windows:

```bash
.\exec.ps1
```

The application will be accessible at http://localhost:3000.

## Issue Reporting

If you have found a bug or if you have a feature request, please report them at this repository issues section. Please do not report security vulnerabilities on the public GitHub issue tracker. The [Responsible Disclosure Program](https://auth0.com/whitehat) details the procedure for disclosing security issues.

## What is Auth0?

Auth0 helps you to:

* Add authentication with [multiple authentication sources](https://docs.auth0.com/identityproviders), either social like **Google, Facebook, Microsoft Account, LinkedIn, GitHub, Twitter, Box, Salesforce, amont others**, or enterprise identity systems like **Windows Azure AD, Google Apps, Active Directory, ADFS or any SAML Identity Provider**.
* Add authentication through more traditional **[username/password databases](https://docs.auth0.com/mysql-connection-tutorial)**.
* Add support for **[linking different user accounts](https://docs.auth0.com/link-accounts)** with the same user.
* Support for generating signed [Json Web Tokens](https://docs.auth0.com/jwt) to call your APIs and **flow the user identity** securely.
* Analytics of how, when and where users are logging in.
* Pull data from other sources and add it to the user profile, through [JavaScript rules](https://docs.auth0.com/rules).

## Create a free account in Auth0

1. Go to [Auth0](https://auth0.com) and click Sign Up.
2. Use Google, GitHub or Microsoft Account to login.



