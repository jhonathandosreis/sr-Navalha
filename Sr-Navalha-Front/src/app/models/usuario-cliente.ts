import { Credencial } from "./credencial";
import { Endereco } from "./endereco";

export class UsuarioCliente {
    id: any;
    nome: any;
    telefone: any;
    email: any;
    dataNascimento: any;
    cpf: any;
    tipo: any;
    endereco: Endereco = new Endereco;
    credencial: Credencial = new Credencial;
}