import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Participante } from '../model/participante';
import { RestService } from '../service/RestService';

@Component({
  selector: 'app-registrar-votacao',
  templateUrl: './registrar-votacao.component.html',
  styleUrls: ['./registrar-votacao.component.css'],
})
export class RegistrarVotacaoComponent implements OnInit {
  title = 'Voto computado';
  voto = '';
  constructor(
    private activatedRoute: ActivatedRoute,
    private restService: RestService
  ) {}

  ngOnInit(): void {
    let id = this.activatedRoute.snapshot.paramMap.get('id');
    this.activatedRoute.queryParams.subscribe((params) => {
      this.enviarVoto(params['id']);
    });
  }

  enviarVoto(id: string) {
    let request = { id: id };
    this.restService.postData('/vote', request).subscribe((response) => {
      let voto = response as Participante;
      this.voto = voto.name;
    });
  }
}
