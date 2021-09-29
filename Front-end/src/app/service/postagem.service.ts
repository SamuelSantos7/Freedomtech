  
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Postagem } from '../model/Postagem';

@Injectable({
  providedIn: 'root'
})
export class PostagemService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAllPostagens(): Observable<Postagem[]>{
    return this.http.get<Postagem[]>('https://freedomtech.herokuapp.com/freedomtech/postagem/todes', this.token)
  }

  getByIdPostagem(id:number): Observable<Postagem>{
    return this.http.get<Postagem>(`https://freedomtech.herokuapp.com/freedomtech/postagem/${id}`, this.token)
  }

  postPostagem(postagem: Postagem): Observable<Postagem>{
    return this.http.post<Postagem>('https://freedomtech.herokuapp.com/freedomtech/postagem/salvar', postagem, this.token) 
  }

  putPostagem(postagem: Postagem): Observable<Postagem>{
    return this.http.put<Postagem>('https://freedomtech.herokuapp.com/freedomtech/postagem/alterar', postagem, this.token)
  }

  deletePostagem(id:number){
    return this.http.delete(`https://freedomtech.herokuapp.com/freedomtech/postagem/${id}`, this.token)
  }
}