package com.hasagawataiga.security;

import com.hasagawataiga.constant.UserRole;
import com.hasagawataiga.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        StringBuilder url = new StringBuilder();
        List<String> roles = SecurityUtils.getAuthorities();
        if (isAdmin(roles)) {
            url.append("/admin");
        }
        url.append("/home");
        return url.toString();
    }

    private boolean isAdmin(List<String> roles) {
        return roles.contains(UserRole.ADMIN.getValue());
    }

    private boolean isUser(List<String> roles) {
        return roles.contains(UserRole.USER.getValue());
    }

    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

}
