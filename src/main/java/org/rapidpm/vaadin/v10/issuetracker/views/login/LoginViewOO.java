/**
 * Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.rapidpm.vaadin.v10.issuetracker.views.login;

import static org.rapidpm.vaadin.v10.issuetracker.views.login.LoginViewOO.NAV_LOGIN_VIEW;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(NAV_LOGIN_VIEW)
public class LoginViewOO extends Composite<HorizontalLayout> {

  public static final String NAV_LOGIN_VIEW = "login";

  private final TextField     username   = new TextField();
  private final PasswordField password   = new PasswordField();
  private final Checkbox      rememberMe = new Checkbox();
  private final Button        btnLogin   = new Button();
  private final Button        btnCancel  = new Button();

  public LoginViewOO() {

    HorizontalLayout input   = new HorizontalLayout(username, password);
    HorizontalLayout buttons = new HorizontalLayout(btnLogin, btnCancel);
    VerticalLayout   groupV  = new VerticalLayout(input, rememberMe, buttons);
    groupV.setDefaultHorizontalComponentAlignment(Alignment.START);
    groupV.setSizeUndefined();


    //I18N
    username.setPlaceholder(getTranslation("login.username.placeholder"));
    password.setPlaceholder(getTranslation("login.password.placeholder"));
    rememberMe.setLabel(getTranslation("login.rememberme.label"));
    btnLogin.setText(getTranslation("login.button.ok.text"));
    btnCancel.setText(getTranslation("login.button.cancel.text"));

    HorizontalLayout content = getContent();
    content.setDefaultVerticalComponentAlignment(Alignment.CENTER);
    content.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
    content.setSizeFull();
    content.add(groupV);

  }

}
