import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './view/inicio/inicio.component';
import { curriculosComponent } from './view/curriculos/curriculos.component';
import { VagasComponent } from './view/vagas/vagas.component';
import { PainelVagasComponent } from './view/painel-vagas/painel-vagas.component';
import { PainelcurriculosComponent } from './view/painel-curriculos/painel-curriculos.component';

const routes: Routes = [
  { path: '', component: InicioComponent }, // Rota para a página inicial
  { path: 'curriculos', component: curriculosComponent }, // Rota para currículos
  { path: 'vagas', component: VagasComponent }, // Rota para vagas
  { path: 'painel-vagas', component: PainelVagasComponent }, // Rota para painel de vagas
  { path: 'painel-curriculos', component: PainelcurriculosComponent } // Rota para painel de vagas
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}
