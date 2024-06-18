import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CharacterService } from 'src/app/service/characterService.service';

@Component({
  selector: 'app-un-character',
  templateUrl: './un-character.component.html',
  styleUrls: ['./un-character.component.css']
})
export class UnCharacterComponent implements OnInit {

  characterr: any = {};

  constructor(
    private activatedRoute: ActivatedRoute,
    private charactersService: CharacterService,

  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe( params => { 
      this.obtenerHeroe(params['id']);
     })
  }

  obtenerHeroe(id) {
    this.charactersService.getCharacterById(id).subscribe(resp => {
      this.characterr = resp.date;
    })
  }

}
