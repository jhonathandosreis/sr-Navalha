import { Cidade } from './cidade';

export class Endereco {
    id: any;
    logradouro: any;
    numero: any;
    bairro: any;
    cep: any;
    cidade: Cidade = new Cidade;
}