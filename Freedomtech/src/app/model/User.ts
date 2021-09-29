import { Postagem } from "./Postagem"

export class User{
    public id: number
    public nome: string
    public email: string
    public login: string
    public senha: string
    public foto: string
    public tipo: string
    public cpf: string
    public Linkedin: string
    public listadePostagens: Postagem[]
}