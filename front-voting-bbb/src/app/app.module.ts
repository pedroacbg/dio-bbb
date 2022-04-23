import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { VotacaoComponent } from './votacao/votacao.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { RegistrarVotacaoComponent } from './registrar-votacao/registrar-votacao.component';

@NgModule({
  declarations: [AppComponent, VotacaoComponent, RegistrarVotacaoComponent],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
