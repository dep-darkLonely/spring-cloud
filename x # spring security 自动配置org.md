```yml
# spring security 自动配置
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration,\
org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,\
org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration,\
org.springframework.boot.autoconfigure.security.rsocket.RSocketSecurityAutoConfiguration,\
org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration,\
# spring security oauth2 自动配置
org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration,\
org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration,\
org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration,\
org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration,\
```

```yml
# Spring Security 自动配置
org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration,
# import 导入一下配置
# 添加默认的spring security filter chain,如果存在用户自定义的SecurityFilterChain和WebSecurityConfigurerAdapter，默认的filter chain将不会起作用
SpringBootWebSecurityConfiguration
# 组合注解，如果工程中存在springSecurityFilterChain Bean 和@EnableWebSecurity 注解的化，该配置不会起作用
# 只有classpath下存在spring security 则会，将会增加@EnableWebSecurity， 表示存在默认的安全配置
WebSecurityEnablerConfiguration
# spring security 继承 spring data的配置
SecurityDataConfiguration
# 错误页面的filter配置
ErrorPageSecurityFilterConfiguration

```

```markdown
@EnableWebSecurity 注解
----------------- 由以下内容组成 -------------------
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({ WebSecurityConfiguration.class, SpringWebMvcImportSelector.class, OAuth2ImportSelector.class,
		HttpSecurityConfiguration.class })
@EnableGlobalAuthentication
@Configuration
public @interface EnableWebSecurity {

	/**
	 * Controls debugging support for Spring Security. Default is false.
	 * @return if true, enables debug support with Spring Security
	 */
	boolean debug() default false;

}

-------------------------------
# 配置对外暴露的HttpSecurity Bean 多实例
HttpSecurityConfiguration
# web security的配置信息
# 可通过WebSecurityConfigurerAdapter 和WebSecurityConfigurer对其进行扩展
# 创建spring security filter chain 过滤器链 对象springSecurityFilterChain
# 自动注入WebSecurityCustomizer和SecurityFilterChain 对象
WebSecurityConfiguration
# 导入 WebMvcSecurityConfiguration的配置信息，针对spring mvc 与 spring security CSRF 的集成添加配置信息
SpringWebMvcImportSelector
# 条件性的导入OAuth2相关配置信息
OAuth2ImportSelector
```

```markdown
======= tomcat 调用 Filter
org.apache.catalina.core.StandardWrapperValve#invoke
======= tomcat 中filter 对象属性
ApplicationFilterConfig[name=springSecurityFilterChain,

# asyncmanager 和 springweb的继承
org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter
#### securityContext 持久化 Filter
org.springframework.security.web.context.SecurityContextPersistenceFilter
### 扩展当前request 的 header ，可增加自定义属性
org.springframework.security.web.header.HeaderWriterFilter
### 防止csrf（跨站伪造） 攻击的filter
org.springframework.security.web.csrf.CsrfFilter
### 登出，清空securityContext上下文
org.springframework.security.web.authentication.logout.LogoutFilter
### 用户、密码认证过滤器
#### 认证流程：
###### 1.是否需要认证
###### 2.尝试认证，成功返回authenticationResult 认证结果, 否则：失败
###### 3.处理session，防止固定会话攻击
###### 4.认证成功之前是否存在filter
###### 5.认证成功之后的行为：1.设置securityContext 2.执行RememberMeServices服务 3.发送一个交互式认证成功的Event 4.委托执行一个成功的Handler
org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
###### 默认生成登录页面的Filter
org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter
###### 默认登出页面的Filter
org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter
###### request cache 缓存Filter
org.springframework.security.web.savedrequest.RequestCacheAwareFilter
###### 
org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter
######
org.springframework.security.web.authentication.AnonymousAuthenticationFilter
org.springframework.security.web.session.SessionManagementFilter
org.springframework.security.web.access.ExceptionTranslationFilter
#### 授权过滤器，用于方法权限的校验
org.springframework.security.web.access.intercept.AuthorizationFilter


```



