import { Servico } from "./servico";

class Agendamento {
    id: any;
    data!: Date;
    horario: any;
    endereco: any;
    servico!: Servico;
}

export { Agendamento };