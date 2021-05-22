import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './view/login/login.component';
import { HomeComponent } from './view/home/home.component';
import { FooterComponent } from './view/footer/footer.component';
import { HeaderComponent } from './view/header/header.component';
import { AdminComponent } from './view/admin/admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AgendamentoComponent } from './view/agendamento/agendamento.component';
<<<<<<< HEAD
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './http.interceptor';
=======
import { CadastroComponent } from './view/cadastro/cadastro.component';
>>>>>>> 8f70d0166c87f34782f205e12c2e035254ee823e

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    AdminComponent,
    AgendamentoComponent,
    CadastroComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }, { provide: LOCALE_ID, useValue: 'pt-Br' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
