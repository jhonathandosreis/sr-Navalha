import { UsuarioCliente } from './usuario-cliente';
import { Servico } from "./servico";
import { Endereco } from './endereco';

class Agendamento {
    id: any;
    data!: Date;
    formaPagamento: any;
    horario: any;
    status: any;
    endereco!: Endereco;
    servico!: any;
    cliente!: any
}

export { Agendamento };