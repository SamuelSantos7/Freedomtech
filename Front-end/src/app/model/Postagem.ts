import { Categoria } from "./Categoria"
import { User } from "./User"

export class Postagem{
   public id: number
   public dataPostagem: Date
   public titulo: string
   public descricao: string
   public usuario: User
   public categoria: Categoria



}